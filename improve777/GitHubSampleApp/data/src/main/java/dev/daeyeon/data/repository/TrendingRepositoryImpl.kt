package dev.daeyeon.data.repository

import dev.daeyeon.data.datasource.RemoteTrendingDataSource
import dev.daeyeon.domain.entity.Language
import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.domain.repository.TrendingRepository
import io.reactivex.Single

class TrendingRepositoryImpl(
    private val remote: RemoteTrendingDataSource
) : TrendingRepository {
    override fun getLanguages(): Single<List<Language>> =
        remote.getLanguages()

    override fun getTrendingRepos(
        language: String,
        since: SinceType
    ): Single<List<TrendingRepo>> =
        remote.getTrendingRepos(language, since)

    override fun getTrendingDevelopers(
        language: String,
        since: SinceType
    ): Single<List<TrendingDeveloper>> =
        remote.getTrendingDevelopers(language, since)

}