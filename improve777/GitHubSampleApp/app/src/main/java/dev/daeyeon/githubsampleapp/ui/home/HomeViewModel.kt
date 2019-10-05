package dev.daeyeon.githubsampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.exception.KakaoException
import dev.daeyeon.common.base.BaseViewModel
import timber.log.Timber

class HomeViewModel(
    private val currentSession: Session,
    private val userManagement: UserManagement
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

    override fun onCleared() {
        Timber.e("onCleared")
        currentSession.removeCallback(sessionCallback)
        super.onCleared()
    }
}