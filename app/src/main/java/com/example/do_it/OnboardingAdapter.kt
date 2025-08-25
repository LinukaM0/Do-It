package com.example.do_it

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(
                title = "Organize Your Tasks",
                description = "Create, manage, and organize all your daily tasks in one place. Stay focused and achieve your goals with our intuitive task management system.",
                imageRes = R.drawable.onboarding_1, // You'll need to add this image
                backgroundColor = "#BEEFF1" // Light indigo background
            )
            1 -> OnboardingFragment.newInstance(
                title = "Track Your Progress",
                description = "Monitor your productivity and see how much you've accomplished. Stay motivated with visual progress tracking and completion statistics.",
                imageRes = R.drawable.onboarding_2, // You'll need to add this image
                backgroundColor = "#BEEFF1" // Light purple background
            )
            2 -> OnboardingFragment.newInstance(
                title = "Boost Productivity",
                description = "Transform your daily routine with smart reminders and priority management. Turn your plans into achievements, one task at a time.",
                imageRes = R.drawable.onboarding_3, // You'll need to add this image
                backgroundColor = "#BEEFF1" // Light green background
            )
            else -> OnboardingFragment.newInstance("", "", 0, "#F9FAFB")
        }
    }
}