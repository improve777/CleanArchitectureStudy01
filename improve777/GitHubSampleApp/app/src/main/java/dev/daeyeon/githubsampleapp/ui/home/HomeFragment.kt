package dev.daeyeon.githubsampleapp.ui.home

import android.os.Bundle
import dev.daeyeon.common.base.BaseFragment
import dev.daeyeon.githubsampleapp.BR
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutId = R.layout.fragment_home,
    bindingVariableId = BR.vm
) {
    override val viewModel: HomeViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()
    }

    override fun initView() {
    }

    override fun onDestroyView() {
        Timber.e("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Timber.e("onDestroy")
        //Session.getCurrentSession().removeCallback(session)
        super.onDestroy()
    }
}