package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.data.datasource.LocalRepoDataSource
import dev.daeyeon.data.datasource.RemoteRepoDataSource
import dev.daeyeon.data.datasource.RemoteTrendingDataSource
import dev.daeyeon.data.repository.RepoRepositoryImpl
import dev.daeyeon.data.repository.TrendingRepositoryImpl
import dev.daeyeon.data.scheduler.SchedulersProvider
import dev.daeyeon.data.scheduler.SchedulersProviderImpl
import dev.daeyeon.domain.repository.RepoRepository
import dev.daeyeon.domain.repository.TrendingRepository
import dev.daeyeon.local.datasource.LocalRepoDataSourceImpl
import dev.daeyeon.local.mapper.RepoLocalMapper
import dev.daeyeon.remote.datasource.RemoteRepoDataSourceImpl
import dev.daeyeon.remote.datasource.RemoteTrendingDataSourceImpl
import dev.daeyeon.remote.mapper.RepoRemoteMapper
import dev.daeyeon.remote.mapper.TrendingRemoteMapper
import org.koin.dsl.module

val dataModule = module {

    single<SchedulersProvider> { SchedulersProviderImpl() }

    single { RepoRemoteMapper() }
    single { TrendingRemoteMapper() }

    single { RepoLocalMapper() }

    single<LocalRepoDataSource> { LocalRepoDataSourceImpl(get(), get(), get()) }

    single<RemoteRepoDataSource> { RemoteRepoDataSourceImpl(get(), get(), get()) }
    single<RemoteTrendingDataSource> { RemoteTrendingDataSourceImpl(get(), get(), get()) }

    single<RepoRepository> { RepoRepositoryImpl(get(), get()) }
    single<TrendingRepository> { TrendingRepositoryImpl(get()) }
}