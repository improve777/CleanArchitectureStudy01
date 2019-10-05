package dev.daeyeon.domain.usecase

import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.domain.repository.TrendingRepository
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

class GetTrendingReposUseCase(
    private val trendingRepository: TrendingRepository
) {
    operator fun invoke(
        language: String,
        since: SinceType,
        onResult: (result: DataResult<List<TrendingRepo>>) -> Unit
    ): Disposable =
        trendingRepository.getTrendingRepos(
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