package com.example.do_it

import android.content.Intent // Added for potential navigation to other activities
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TimeManagementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time)

        // Find views - Corrected ID for the Add Task button
        val addTaskButton = findViewById<Button>(R.id.addTaskButton) // Changed from add_btn to addTaskButton
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set up add task button
        addTaskButton.setOnClickListener {
            // Handle add task functionality here
            // Example: Toast.makeText(this, "Add Task clicked in Time Management!", Toast.LENGTH_SHORT).show()
        }

        // Set up bottom navigation within this activity
        // Note: This BottomNavigationView is separate from the one in MainActivity
        // and will only function within TimeManagementActivity.
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                // Assuming R.id.navigation_home corresponds to your Home icon in nav_menu
                R.id.home -> { // Use the actual ID from nav_menu.xml
                    // Navigate back to MainActivity (which will show the HomeFragment)
                    finish()
                    true
                }
                R.id.settings -> { // Use the actual ID from nav_menu.xml
                    // Handle settings for this activity, or launch a new SettingsActivity if needed
                    // val intent = Intent(this, SettingsActivity::class.java)
                    // startActivity(intent)
                    true
                }
                R.id.profile -> { // Use the actual ID from nav_menu.xml
                    // Handle profile for this activity, or launch a new ProfileActivity if needed
                    // val intent = Intent(this, ProfileActivity::class.java)
                    // startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
