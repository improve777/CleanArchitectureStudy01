package dev.daeyeon.githubsampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.kakaotalk.callback.TalkResponseCallback
import com.kakao.kakaotalk.v2.KakaoTalkService
import com.kakao.message.template.ButtonObject
import com.kakao.message.template.ContentObject
import com.kakao.message.template.LinkObject
import com.kakao.message.template.ListTemplate
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException
import dev.daeyeon.common.base.BaseViewModel
import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.domain.usecase.GetTrendingReposUseCase
import timber.log.Timber

class HomeViewModel(
    private val currentSession: Session,
    private val userManagement: UserManagement,
    private val kakaoTalkService: KakaoTalkService,
    private val getTrendingReposUseCase: GetTrendingReposUseCase
) : BaseViewModel() {

    private val sessionCallback: ISessionCallback by lazy { createSessionCallback() }

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> = _isLogin

    init {
        currentSession.addCallback(sessionCallback)
        currentSession.checkAndImplicitOpen()

        Timber.e("init HomeViewModel")
    }

    private fun createSessionCallback() =
        object : ISessionCallback {
            override fun onSessionOpened() {
                requestMe()
            }

            override fun onSessionOpenFailed(exception: KakaoException?) {
                if (exception != null) {
                    Timber.w(exception)
                }
            }
        }

    private fun requestMe() {
        val keys = listOf(
            "properties.nickname",
            "properties.profile_image",
            "kakao_account.email"
        )

        UserManagement.getInstance().me(keys, object : MeV2ResponseCallback() {

            override fun onFailure(errorResult: ErrorResult?) {
                super.onFailure(errorResult)
                if (errorResult != null) {
                    Timber.w(errorResult.exception)
                }
            }

            override fun onSuccess(result: MeV2Response?) {
                Timber.e(result.toString())
                changeLoginState()
            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
                if (errorResult != null) {
                    Timber.w(errorResult.exception)
                }
            }

        })
    }

    fun logout() {
        userManagement.requestLogout(object : LogoutResponseCallback() {
            override fun onSuccess(result: Long?) {
                super.onSuccess(result)
                changeLogoutState()
            }

            override fun onCompleteLogout() {}
        })
    }

    fun changeLoginState() {
        _isLogin.value = true
    }

    fun changeLogoutState() {
        _isLogin.value = false
    }

    fun requestKakaoLinkMe() {
        getTrendingReposUseCase(
            "kotlin",
            SinceType.DAILY
        ) {
            when (it) {
                is DataResult.Success -> {
                    _isShowProgressBar.value = false

                    val template = getKakaoLinkListTemplate(createContentObjectList(it.data))
                    sendMeTrendList(template)

                }
                is DataResult.Error -> {
                    _isShowProgressBar.value = false
                }
                DataResult.Loading -> {
                    _isShowProgressBar.value = true
                }
            }
        }
    }

    private fun sendMeTrendList(template: ListTemplate) {
        kakaoTalkService.requestSendMemo(
            object : TalkResponseCallback<Boolean?>() {
                // 발신자가 카카오톡 유저가 아님
                override fun onNotKakaoTalkUser() {

                }

                // 그 외 에러
                override fun onFailure(errorResult: ErrorResult?) {
                    super.onFailure(errorResult)
                    if (errorResult != null) {
                        Timber.w(errorResult.exception)
                    }

                }

                // API  호출 성공.
                override fun onSuccess(result: Boolean?) {
                    if (result != null && result == true) {
                        sendToast("보내기 성공")
                    } else {
                        sendToast("보내기 실패")
                    }
                }

                // 액세스토큰 및 리프레시토큰이 만료됨. 재로그인 필요.
                override fun onSessionClosed(errorResult: ErrorResult?) {
                    if (errorResult != null) {
                        Timber.w(errorResult.exception)
                    }
                }
            },
            template
        )
    }

    private fun getKakaoLinkListTemplate(items: List<ContentObject>): ListTemplate {
        val builder = ListTemplate.newBuilder(
            "Github Trending",
            LinkObject.newBuilder()
                .setWebUrl("https://github.com/trending")
                // .setMobileWebUrl("https://github.com/trending")
                .build()
        )
            .addButton(
                ButtonObject(
                    "더보기",
                    LinkObject.newBuilder()
                        .setWebUrl("https://github.com/trending")
                        // .setMobileWebUrl("https://github.com/trending")
                        .build()
                )
            )

        items.forEach {
            builder.addContent(it)
        }

        return builder.build()
    }

    private fun createContentObjectList(items: List<TrendingRepo>) =
        items.filterIndexed { index, _ -> index < 5 }
            .map {
                ContentObject.newBuilder(
                    it.name,
                    it.avatar,
                    LinkObject.newBuilder()
                        .setWebUrl(it.url)
                        // .setMobileWebUrl(it.url)
                        .build()
                )
                    .setDescrption(it.description)
                    .build()
            }

    override fun onCleared() {
        Timber.e("onCleared")
        currentSession.removeCallback(sessionCallback)
        super.onCleared()
    }
}