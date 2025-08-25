package com.example.do_it

import android.content.Intent // Import for launching other activities
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast // Import Toast for user feedback
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TodoListActivity : AppCompatActivity() {

    private lateinit var etNewTask: EditText
    private lateinit var etTask1: EditText
    private lateinit var etTask2: EditText
    private lateinit var etTask3: EditText
    private lateinit var btnAddTask: Button
    private lateinit var btnClearAll: Button
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.to_do)

        // Initialize views
        etNewTask = findViewById(R.id.et_new_task)
        etTask1 = findViewById(R.id.et_task1)
        etTask2 = findViewById(R.id.et_task2)
        etTask3 = findViewById(R.id.et_task3)
        btnAddTask = findViewById(R.id.btn_add_task)
        btnClearAll = findViewById(R.id.btn_clear_all)
        bottomNavigationView = findViewById(R.id.bottom_navigation) // Correctly initialize BottomNavigationView

        // Set up Add Task button functionality
        btnAddTask.setOnClickListener {
            addTask()
        }

        // Set up Clear All button functionality
        btnClearAll.setOnClickListener {
            clearAllTasks()
        }

        // Handle bottom navigation item clicks for THIS activity
        // Note: This BottomNavigationView instance is local to TodoListActivity.
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> { // Correct ID from nav_menu.xml
                    // If you want to go back to the MainActivity (which hosts the HomeFragment), use finish()
                    // or start a new Intent for MainActivity and clear the task stack if needed.
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish() // Close TodoListActivity
                    true
                }
                R.id.settings -> { // Correct ID from nav_menu.xml
                    // Example: Launch a SettingsActivity if you have one, or just show a toast.
                    Toast.makeText(this, "Settings clicked from TodoList!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> { // Correct ID from nav_menu.xml
                    // Example: Launch a ProfileActivity if you have one, or just show a toast.
                    Toast.makeText(this, "Profile clicked from TodoList!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun addTask() {
        val newTaskText = etNewTask.text.toString().trim()
        if (newTaskText.isNotEmpty()) {
            when {
                etTask1.text.toString().isEmpty() -> {
                    etTask1.setText(newTaskText)
                    etNewTask.text.clear()
                    Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
                }
                etTask2.text.toString().isEmpty() -> {
                    etTask2.setText(newTaskText)
                    etNewTask.text.clear()
                    Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
                }
                etTask3.text.toString().isEmpty() -> {
                    etTask3.setText(newTaskText)
                    etNewTask.text.clear()
                    Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    etNewTask.error = "All task fields are filled! Clear some to add more."
                    Toast.makeText(this, "All task fields are filled!", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            etNewTask.error = "Please enter a task"
            Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearAllTasks() {
        etTask1.text.clear()
        etTask2.text.clear()
        etTask3.text.clear()
        etNewTask.text.clear()
        Toast.makeText(this, "All tasks cleared!", Toast.LENGTH_SHORT).show()
    }
}
