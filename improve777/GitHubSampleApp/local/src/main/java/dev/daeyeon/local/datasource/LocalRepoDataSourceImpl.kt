package dev.daeyeon.local.datasource

import dev.daeyeon.data.datasource.LocalRepoDataSource
import dev.daeyeon.local.dao.RepoDao
import dev.daeyeon.local.mapper.RepoLocalMapper
import dev.daeyeon.domain.entity.Repo
import dev.daeyeon.data.scheduler.SchedulersProvider
import io.reactivex.Completable
import io.reactivex.Maybe

class LocalRepoDataSourceImpl(
    private val repoDao: RepoDao,
    private val scheduler: SchedulersProvider,
    private val repoMapper: RepoLocalMapper
) : LocalRepoDataSource {

    override fun insertRepo(repo: Repo): Completable =
        repoDao.insert(repoMapper.toRepoEntity(repo))
            .subscribeOn(scheduler.io())

    override fun insertAllRepo(repos: List<Repo>): Completable {
        val repoEntities = repos.map(repoMapper::toRepoEntity)

        // https://github.com/kotlin-korea/Study-Log/issues/12
        return repoDao.insert(*repoEntities.toTypedArray())
            .subscribeOn(scheduler.io())
    }

    override fun getRepos(userName: String): Maybe<List<Repo>> =
        repoDao.getRepos(userName)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .map { it.map(repoMapper::toRepo) }
}