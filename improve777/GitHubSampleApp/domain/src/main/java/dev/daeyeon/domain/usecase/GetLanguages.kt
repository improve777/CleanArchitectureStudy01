package dev.daeyeon.domain.usecase

import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.Language
import dev.daeyeon.domain.repository.TrendingRepository
import io.reactivex.rxkotlin.subscribeBy

class GetLanguages(
    private val trendingRepository: TrendingRepository
) {
    operator fun invoke(
        onResult: (result: DataResult<List<Language>>) -> Unit
    ) =
        trendingRepository.getLanguages()
            .subscribeBy(
                onError = {
                    onResult(DataResult.error(it))
                },
                onSuccess = {
                    onResult(DataResult.success(it))
                }
            )
}