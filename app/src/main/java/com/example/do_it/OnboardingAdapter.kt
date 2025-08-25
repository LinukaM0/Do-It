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
                description = "Create, manage, and organize all your daily tasks in one place. Stay focused and productive with our intuitive task management system.",
                imageRes = R.drawable.onboarding_1, // You'll need to add this image
                backgroundColor = "#E3F2FD"
            )
            1 -> OnboardingFragment.newInstance(
                title = "Manage Your Time",
                description = "Schedule your tasks with specific time slots. Track your progress and make the most of your day with smart time allocation.",
                imageRes = R.drawable.onboarding_2, // You'll need to add this image
                backgroundColor = "#F3E5F5"
            )
            2 -> OnboardingFragment.newInstance(
                title = "Boost Productivity",
                description = "Achieve your goals faster with our productivity tools. Turn your plans into reality and celebrate your accomplishments.",
                imageRes = R.drawable.onboarding_3, // You'll need to add this image
                backgroundColor = "#E8F5E8"
            )
            else -> OnboardingFragment.newInstance("", "", 0, "#FFFFFF")
        }
    }
}