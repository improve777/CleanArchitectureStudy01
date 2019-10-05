package dev.daeyeon.data.datasource

import dev.daeyeon.domain.entity.Language
import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import io.reactivex.Single

interface RemoteTrendingDataSource {
    fun getLanguages(): Single<List<Language>>

    fun getTrendingRepos(
        language: String,
        since: SinceType
    ): Single<List<TrendingRepo>>

    fun getTrendingDevelopers(
        language: String,
        since: SinceType
    ): Single<List<TrendingDeveloper>>
}