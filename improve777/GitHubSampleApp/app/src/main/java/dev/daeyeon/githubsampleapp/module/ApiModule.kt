package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.remote.api.GithubApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    single {
        (get() as Retrofit).create(GithubApi::class.java)
    }
}