package dev.daeyeon.githubsampleapp.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dev.daeyeon.common.base.BaseActivity
import dev.daeyeon.common.base.BaseViewModel
import dev.daeyeon.githubsampleapp.R
import dev.daeyeon.githubsampleapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>(
    layoutId = R.layout.activity_main
) {
    override val viewModel: BaseViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        val host = supportFragmentManager
            .findFragmentById(R.id.fragment_nav_host) as? NavHostFragment ?: return

        val navController = host.navController

        initBottomNavView(navController)
    }

    private fun initBottomNavView(navController: NavController) {
        binding.bottomNavView.setupWithNavController(navController)
    }
}
