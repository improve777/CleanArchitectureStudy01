package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.data.datasource.LocalRepoDataSource
import dev.daeyeon.data.datasource.RemoteRepoDataSource
import dev.daeyeon.data.local.LocalRepoDataSourceImpl
import dev.daeyeon.data.mapper.RepoMapper
import dev.daeyeon.data.repository.RepoRepositoryImpl
import dev.daeyeon.data.scheduler.SchedulersProvider
import dev.daeyeon.data.scheduler.SchedulersProviderImpl
import dev.daeyeon.domain.repository.RepoRepository
import dev.daeyeon.remote.datasource.RemoteRepoDataSourceImpl
import dev.daeyeon.remote.mapper.RepoRemoteMapper
import org.koin.dsl.module

val dataModule = module {

    single<SchedulersProvider> { SchedulersProviderImpl() }

    single { RepoRemoteMapper() }

    single { RepoMapper() }

    single<LocalRepoDataSource> { LocalRepoDataSourceImpl(get(), get(), get()) }

    single<RemoteRepoDataSource> { RemoteRepoDataSourceImpl(get(), get(), get()) }

    single<RepoRepository> { RepoRepositoryImpl(get(), get()) }
}