package com.demo.navigation1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.empty, R.string.empty)
        toggle.setToolbarNavigationClickListener {
            onBackPressed()
        }
        toggle.syncState()

        drawer_layout.addDrawerListener(toggle)

        nav_view.setNavigationItemSelectedListener {
            if(bottom_navigation.menu.findItem(it.itemId) != null){
                bottom_navigation.selectedItemId = it.itemId
                bottom_navigation.visibility = View.VISIBLE
            } else {
                bottom_navigation.visibility = View.GONE
            }
            selectMenuItem(it)
        }



        bottom_navigation.setOnNavigationItemSelectedListener {
            nav_view.setCheckedItem(it)
            selectMenuItem(it)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, FirstFragment(), "first")
                .commit()
        }
    }

    private fun selectMenuItem(menuItem: MenuItem): Boolean{
        if(drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun disableMenu() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        toggle.isDrawerIndicatorEnabled = false
    }

    fun enableMenu() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        toggle.isDrawerIndicatorEnabled = true
    }

}
