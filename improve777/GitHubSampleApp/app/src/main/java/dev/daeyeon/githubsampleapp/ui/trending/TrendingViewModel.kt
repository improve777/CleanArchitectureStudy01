package dev.daeyeon.githubsampleapp.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.daeyeon.common.base.BaseViewModel
import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.domain.enum.SinceType
import dev.daeyeon.domain.usecase.GetTrendingDevelopersUseCase
import dev.daeyeon.domain.usecase.GetTrendingReposUseCase
import dev.daeyeon.githubsampleapp.model.mapper.toPresentation

class TrendingViewModel(
    private val getTrendingReposUseCase: GetTrendingReposUseCase,
    private val getTrendingDevelopersUseCase: GetTrendingDevelopersUseCase
) : BaseViewModel() {

    private val _trendingList = MutableLiveData<List<Any>>()
    val trendingList: LiveData<List<Any>> = _trendingList

    init {
        getList()
    }

    fun getList() {
        getTrendingReposUseCase(
            language = "kotlin",
            since = SinceType.DAILY,
            onResult = {
                when (it) {
                    is DataResult.Success -> {
                        _isShowProgressBar.value = false
                        _trendingList.value = it.data.map(TrendingRepo::toPresentation)
                    }
                    is DataResult.Error -> {
                        _isShowProgressBar.value = false
                    }
                    DataResult.Loading -> {
                        _isShowProgressBar.value = true
                    }
                }
            }
        )
    }
}