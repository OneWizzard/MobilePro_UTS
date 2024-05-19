package com.application.uts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.application.uts.fragment.FragmentHome
import com.application.uts.fragment.FragmentProfile
import com.application.uts.fragment.FragmentNews
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Set the initial fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerLayout, FragmentHome())
                .commit()
        }

        // Set up the bottom navigation listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> selectedFragment = FragmentHome()
                R.id.nav_berita -> selectedFragment = FragmentNews()
                R.id.nav_profile -> selectedFragment = FragmentProfile()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerLayout, selectedFragment)
                    .commit()
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_add_data -> {
                // Handle Add Data option
                val intent = Intent(this, AddData::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_alumni_data -> {
                // Handle Alumni Data option
                val intent = Intent(this, DataAlumni::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_logout -> {
                // Handle Logout option
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun enableEdgeToEdge() {
        // Implement this method if necessary to enable edge-to-edge display
    }
}