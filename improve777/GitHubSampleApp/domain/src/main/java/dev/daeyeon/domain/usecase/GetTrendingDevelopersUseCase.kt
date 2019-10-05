package dev.daeyeon.domain.usecase

import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.domain.repository.TrendingRepository
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

class GetTrendingDevelopersUseCase(
    private val trendingRepository: TrendingRepository
) {
    operator fun invoke(
        language: String,
        since: SinceType,
        onResult: (result: DataResult<List<TrendingDeveloper>>) -> Unit
    ): Disposable =
        trendingRepository.getTrendingDevelopers(
            language = language,
            since = since
        )
            .doOnSubscribe { onResult(DataResult.loading()) }
            .subscribeBy(
                onError = {
                    onResult(DataResult.error(it))
                },
                onSuccess = {
                    onResult(DataResult.success(it))
                }
            )
}