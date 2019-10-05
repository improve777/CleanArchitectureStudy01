package dev.daeyeon.githubsampleapp.module

import dev.daeyeon.domain.usecase.GetReposUseCase
import dev.daeyeon.domain.usecase.GetTrendingDevelopersUseCase
import dev.daeyeon.domain.usecase.GetTrendingReposUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetReposUseCase(get()) }

    single { GetTrendingReposUseCase(get()) }
    single { GetTrendingDevelopersUseCase(get()) }
}