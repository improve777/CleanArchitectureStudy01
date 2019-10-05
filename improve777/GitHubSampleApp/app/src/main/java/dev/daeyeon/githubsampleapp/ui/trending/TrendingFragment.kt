package dev.daeyeon.githubsampleapp.ui.trending

import android.os.Bundle
import dev.daeyeon.common.base.BaseFragment
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.FragmentTrendingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment : BaseFragment<FragmentTrendingBinding, TrendingViewModel>(
    R.layout.fragment_trending
) {
    override val viewModel: TrendingViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun initView() {
    }
}