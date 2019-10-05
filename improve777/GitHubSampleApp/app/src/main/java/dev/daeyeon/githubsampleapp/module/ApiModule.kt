package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.remote.api.GithubApi
import dev.daeyeon.remote.api.TrendingApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    single {
        (get(named("github")) as Retrofit).create(GithubApi::class.java)
    }

    single {
        (get(named("trending")) as Retrofit).create(TrendingApi::class.java)
    }
}