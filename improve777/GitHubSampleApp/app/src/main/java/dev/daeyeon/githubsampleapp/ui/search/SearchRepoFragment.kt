package dev.daeyeon.githubsampleapp.ui.search

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.DiffUtil
import dev.daeyeon.common.base.BaseFragment
import dev.daeyeon.common.base.SimpleRecyclerView
import dev.daeyeon.common.ext.hideKeyboard
import dev.daeyeon.githubsampleapp.BR
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.FragmentSearchRepoBinding
import dev.daeyeon.githubsampleapp.databinding.ItemRepoBinding
import dev.daeyeon.githubsampleapp.model.RepoModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchRepoFragment : BaseFragment<FragmentSearchRepoBinding, SearchRepoViewModel>(
    layoutId = R.layout.fragment_search_repo,
    bindingVariableId = BR.vm
) {
    override val viewModel: SearchRepoViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()
    }

    override fun initView() {
        initEtSearchOption()
        initRecyclerViewAdapter()
    }

    private fun initEtSearchOption() {
        binding.etMainSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchRepos(true)
                activity!!.hideKeyboard()
            }
            return@setOnEditorActionListener true
        }
    }

    private fun initRecyclerViewAdapter() {
        binding.rvMain.adapter =
            object : SimpleRecyclerView.ListAdapter<RepoModel, ItemRepoBinding>(
                layoutRes = R.layout.item_repo,
                bindingVariableId = BR.repo,
                diffCallback = object : DiffUtil.ItemCallback<RepoModel>() {
                    override fun areItemsTheSame(oldItem: RepoModel, newItem: RepoModel): Boolean {
                        return oldItem.id == newItem.id
                    }

                    override fun areContentsTheSame(
                        oldItem: RepoModel,
                        newItem: RepoModel
                    ): Boolean {
                        return oldItem == newItem
                    }
                }
            ) {}
    }
}