package dev.daeyeon.githubsampleapp

import android.app.Application
import com.kakao.auth.IApplicationConfig
import com.kakao.auth.KakaoAdapter
import com.kakao.auth.KakaoSDK
import dev.daeyeon.common.BuildConfig
import dev.daeyeon.common.ext.initKoin
import dev.daeyeon.common.module.createNetworkModule
import dev.daeyeon.githubsampleapp.module.*
import timber.log.Timber

class GithubSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        initKakao()

        initKoin(
            applicationContext = this,
            isDebuggable = BuildConfig.DEBUG,
            modules = listOf(
                createNetworkModule("github", "https://api.github.com/", BuildConfig.DEBUG),
                createNetworkModule("trending", "https://github-trending-api.now.sh/", BuildConfig.DEBUG),
                apiModule,
                persistenceModule,
                dataModule,
                useCaseModule,
                viewModelModule
            )
        )
    }

    private fun initKakao() {
        KakaoSDK.init(object : KakaoAdapter() {
            override fun getApplicationConfig() =
                IApplicationConfig { this@GithubSampleApplication.applicationContext }
        })
    }
}