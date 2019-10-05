package dev.daeyeon.githubsampleapp.ui.home

import android.os.Bundle
import dev.daeyeon.common.base.BaseFragment
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    R.layout.fragment_home
) {
    override val viewModel: HomeViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun initView() {
    }

}