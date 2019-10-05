package dev.daeyeon.remote.api

import dev.daeyeon.remote.response.LanguageResponse
import dev.daeyeon.remote.response.TrendingDeveloperResponse
import dev.daeyeon.remote.response.TrendingRepoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {

    @GET("languages")
    fun getLanguages(): Single<List<LanguageResponse>>

    @GET("repositories")
    fun getTrendingRepos(
        @Query("language") language: String,
        @Query("since") since: String
    ): Single<List<TrendingRepoResponse>>

    @GET("developers")
    fun getTrendingDevelopers(
        @Query("language") language: String,
        @Query("since") since: String
    ): Single<List<TrendingDeveloperResponse>>
}