package dev.daeyeon.remote.datasource

import dev.daeyeon.data.datasource.RemoteTrendingDataSource
import dev.daeyeon.data.scheduler.SchedulersProvider
import dev.daeyeon.domain.entity.Language
import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.remote.api.TrendingApi
import dev.daeyeon.remote.mapper.TrendingRemoteMapper
import io.reactivex.Single

class RemoteTrendingDataSourceImpl(
    private val trendingApi: TrendingApi,
    private val schedulersProvider: SchedulersProvider,
    private val trendingRemoteMapper: TrendingRemoteMapper
) : RemoteTrendingDataSource {

    override fun getLanguages(): Single<List<Language>> =
        trendingApi.getLanguages()
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .map { it.map(trendingRemoteMapper::toLanguage) }

    override fun getTrendingRepos(
        language: String, since: SinceType
    ): Single<List<TrendingRepo>> =
        trendingApi.getTrendingRepos(
            language,
            since.param
        )
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .map { it.map(trendingRemoteMapper::toTrendingRepo) }

    override fun getTrendingDevelopers(
        language: String,
        since: SinceType
    ): Single<List<TrendingDeveloper>> =
        trendingApi.getTrendingDevelopers(
            language,
            since.param
        )
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
            .map { it.map(trendingRemoteMapper::toTrendingDeveloper) }
}