package dev.daeyeon.githubsampleapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.daeyeon.common.base.BaseViewModel
import dev.daeyeon.domain.DataResult
import dev.daeyeon.domain.entity.Repo
import dev.daeyeon.domain.usecase.GetReposUseCase
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.model.RepoModel
import dev.daeyeon.githubsampleapp.model.mapper.toPresentation
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class SearchRepoViewModel(
    private val getReposUseCase: GetReposUseCase
) : BaseViewModel() {

    private val _repos = MutableLiveData<List<RepoModel>>()
    val repos: LiveData<List<RepoModel>> = _repos

    val searchKeyword = MutableLiveData<String>()

    fun searchRepos() {
        searchRepos(true)
    }

    fun searchRepos(isForceUpdate: Boolean) {
        if (searchKeyword.value.isNullOrEmpty()) {
            sendToast(R.string.main_input_search_text_plz)
            return
        }

        getReposUseCase(
            userName = searchKeyword.value ?: "",
            isForceUpdate = isForceUpdate,
            onResult = {
                when (it) {
                    is DataResult.Success -> {
                        _isShowProgressBar.value = false
                        _repos.value = it.data.map(Repo::toPresentation)
                    }
                    is DataResult.Error -> {
                        _isShowProgressBar.value = false
                        Timber.w(it.error)
                        sendToast(it.error.message)
                    }
                    DataResult.Loading -> {
                        _isShowProgressBar.value = true

                    }
                }
            }
        )
            .addTo(compositeDisposable)
    }
}