package com.example.do_it

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home, container, false)

        // Initialize views
        val profileImageView: ImageView = view.findViewById(R.id.prof_pic)
        val nameTextView: TextView = view.findViewById(R.id.name)
        val mainImageView: ImageView = view.findViewById(R.id.imageView)
        val sloganTextView: TextView = view.findViewById(R.id.text1)
        val todoListButton: TextView = view.findViewById(R.id.todo_list)
        val manageTimeButton: TextView = view.findViewById(R.id.manage_time)

        // Set initial text
        nameTextView.text = "Dasunika"
        sloganTextView.text = "Stay Organized and Boost Productivity"

        // Set up navigation
        todoListButton.setOnClickListener {
            val intent = Intent(requireContext(), TodoListActivity::class.java)
            startActivity(intent)
        }

        manageTimeButton.setOnClickListener {
            val intent = Intent(requireContext(), TimeManagementActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}