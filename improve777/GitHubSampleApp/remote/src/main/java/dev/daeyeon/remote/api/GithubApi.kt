package dev.daeyeon.remote.api

import dev.daeyeon.remote.response.RepoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{username}/repos")
    fun getRepos(
        @Path("username") userName: String
    ): Single<List<RepoResponse>>
}