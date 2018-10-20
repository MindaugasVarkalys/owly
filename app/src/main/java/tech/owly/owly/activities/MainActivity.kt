package tech.owly.owly.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.owly.owly.R
import tech.owly.owly.fragments.*

class MainActivity : AppCompatActivity() {

    private val feedFragment = FeedFragment()
    private val gradesFragment = ModulesFragment()
    private val mailFragment = MailFragment()
    private val scheduleFragment = ScheduleFragment()
    private val settingsFragment = SettingsFragment()

    private val fragmentManager = supportFragmentManager
    private var active: Fragment = feedFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.selectedItemId = R.id.navigation_feed

        fragmentManager.beginTransaction().add(R.id.fragment_container, feedFragment).commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_feed -> showFragment(feedFragment)
            R.id.navigation_grades -> showFragment(gradesFragment)
            R.id.navigation_mail -> showFragment(mailFragment)
            R.id.navigation_schedule -> showFragment(scheduleFragment)
            R.id.navigation_settings -> showFragment(settingsFragment)
            else -> false
        }
    }

    private fun showFragment(fragment: Fragment): Boolean {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        active = fragment
        return true
    }
}
