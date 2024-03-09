package com.bhavani.performanceanalyzer.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bhavani.performanceanalyzer.R
import com.bhavani.performanceanalyzer.common.replace
import com.bhavani.performanceanalyzer.common.showSnackBar
import com.bhavani.performanceanalyzer.databinding.ActivityDashboardBinding
import com.bhavani.performanceanalyzer.ui.fragments.HomeFragment
import com.bhavani.performanceanalyzer.ui.fragments.UserFragment
import java.lang.IllegalArgumentException

class DashboardActivity : AppCompatActivity() {

    private val viewBinding: ActivityDashboardBinding by lazy { ActivityDashboardBinding.inflate(layoutInflater) }
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        viewBinding.bottomNavigationView.setOnItemSelectedListener { handleNavigationItemSelection(it.itemId) }
        viewBinding.bottomNavigationView.selectedItemId = HOME_SCREEN_ID
    }

    private fun handleNavigationItemSelection(itemId: Int): Boolean {
        when (itemId) {
            HOME_SCREEN_ID -> replaceFragment(HomeFragment.instance())
            USER_SCREEN_ID -> replaceFragment(UserFragment.instance())
            else -> throw IllegalArgumentException("invalid item id")
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.replace(R.id.frame_layout, fragment)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + BACK_PRESS_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            viewBinding.root.showSnackBar("Press back again to exit")
        }
        backPressedTime = System.currentTimeMillis()
    }

    companion object {

        private const val BACK_PRESS_INTERVAL = 2000

        private val HOME_SCREEN_ID = R.id.home_screen_id
        private val USER_SCREEN_ID = R.id.user_screen_id

        fun start(context: Context) = context.startActivity(Intent(context, DashboardActivity::class.java))

    }
}