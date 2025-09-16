// Faizan king App 👑
// Developed by Farooq King

package com.faizanking.app

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.farooqking.app.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeUtils.applySavedTheme(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menu button opens drawer
        binding.menuButton.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // Theme toggle
        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            ThemeUtils.saveTheme(this, isChecked)
            ThemeUtils.applyTheme(isChecked)
        }

        // Side light toggle
        binding.sideLightSwitch.setOnCheckedChangeListener { _, isChecked ->
            setBulbState(isChecked)
        }

        // Initialize states
        binding.themeSwitch.isChecked = ThemeUtils.isDarkTheme(this)
        binding.sideLightSwitch.isChecked = ThemeUtils.isLightOn(this)
        setBulbState(binding.sideLightSwitch.isChecked)
    }

    private fun setBulbState(on: Boolean) {
        val bulb = binding.bulbImage
        val glow = binding.bulbGlow
        if (on) {
            bulb.animate().scaleX(1.08f).scaleY(1.08f).setDuration(350).start()
            glow.animate().alpha(1f).setDuration(450).start()
        } else {
            bulb.animate().scaleX(1f).scaleY(1f).setDuration(250).start()
            glow.animate().alpha(0f).setDuration(300).start()
        }
        ThemeUtils.saveLightState(this, on)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
