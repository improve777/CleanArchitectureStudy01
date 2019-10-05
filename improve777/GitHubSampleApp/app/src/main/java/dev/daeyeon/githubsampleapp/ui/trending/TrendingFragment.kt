package dev.daeyeon.githubsampleapp.ui.trending

import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import dev.daeyeon.common.base.BaseFragment
import dev.daeyeon.common.base.SimpleRecyclerView
import dev.daeyeon.githubsampleapp.BR
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.FragmentTrendingBinding
import dev.daeyeon.githubsampleapp.databinding.ItemTrendingDeveloperBinding
import dev.daeyeon.githubsampleapp.databinding.ItemTrendingRepoBinding
import dev.daeyeon.githubsampleapp.model.TrendingRepoModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment : BaseFragment<FragmentTrendingBinding, TrendingViewModel>(
    layoutId = R.layout.fragment_trending,
    bindingVariableId = BR.vm
) {
    override val viewModel: TrendingViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    override fun initView() {
        bind {
            rvTrending.adapter = object : SimpleRecyclerView.Adapter<Any, ViewDataBinding>() {

                private val VIEWTYPE_REPO = 0
                private val VIEWTYPE_DEVELOPER = 1

                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): SimpleRecyclerView.ViewHolder<ViewDataBinding> {
                    return if (viewType == VIEWTYPE_REPO) {
                        object : SimpleRecyclerView.ViewHolder<ItemTrendingRepoBinding>(
                            layoutRes = R.layout.item_trending_repo,
                            parent = parent,
                            bindingVariableId = BR.trendingRepo
                        ) {}
                    } else {
                        object : SimpleRecyclerView.ViewHolder<ItemTrendingDeveloperBinding>(
                            layoutRes = R.layout.item_trending_developer,
                            parent = parent,
                            bindingVariableId = BR.trendingDeveloper
                        ) {}
                    }
                }

                @Suppress("UNCHECKED_CAST")
                override fun onBindViewHolder(
                    holder: SimpleRecyclerView.ViewHolder<ViewDataBinding>,
                    position: Int
                ) {
                    val viewType = getItemViewType(position)
                    if (viewType == VIEWTYPE_REPO) {
                        (holder as? SimpleRecyclerView.ViewHolder<ItemTrendingRepoBinding>)?.onBindViewHolder(
                            items[position]
                        )
                    } else if (viewType == VIEWTYPE_DEVELOPER) {
                        (holder as? SimpleRecyclerView.ViewHolder<ItemTrendingDeveloperBinding>)?.onBindViewHolder(
                            items[position]
                        )
                    }
                }

                override fun getItemViewType(position: Int): Int {
                    return if (items[position] is TrendingRepoModel) {
                        VIEWTYPE_REPO
                    } else {
                        VIEWTYPE_DEVELOPER
                    }
                }
            }
        }
    }
}