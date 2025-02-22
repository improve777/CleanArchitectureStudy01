package dev.daeyeon.githubsampleapp.module

import com.kakao.auth.Session
import com.kakao.kakaotalk.v2.KakaoTalkService
import com.kakao.usermgmt.UserManagement
import dev.daeyeon.common.base.BaseViewModel
import dev.daeyeon.githubsampleapp.ui.home.HomeViewModel
import dev.daeyeon.githubsampleapp.ui.search.SearchRepoViewModel
import dev.daeyeon.githubsampleapp.ui.trending.TrendingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<BaseViewModel> { object : BaseViewModel() {} }

    viewModel { SearchRepoViewModel(get()) }
    viewModel {
        HomeViewModel(
            Session.getCurrentSession(),
            UserManagement.getInstance(),
            KakaoTalkService.getInstance(),
            get()
        )
    }
    viewModel { TrendingViewModel(get(), get()) }
}