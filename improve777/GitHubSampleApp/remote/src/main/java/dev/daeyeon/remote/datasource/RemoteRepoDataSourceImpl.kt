package dev.daeyeon.remote.datasource

import dev.daeyeon.data.datasource.RemoteRepoDataSource
import dev.daeyeon.data.scheduler.SchedulersProvider
import dev.daeyeon.remote.api.GithubApi
import dev.daeyeon.remote.mapper.RepoRemoteMapper

class RemoteRepoDataSourceImpl(
    private val githubApi: GithubApi,
    private val scheduler: SchedulersProvider,
    private val repoMapper: RepoRemoteMapper
) : RemoteRepoDataSource {

    override fun getRepos(userName: String) =
        githubApi.getRepos(userName)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .map { it.map(repoMapper::toRepo) }
}