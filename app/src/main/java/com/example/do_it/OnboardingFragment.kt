package com.example.do_it

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingFragment : Fragment() {

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"
        private const val ARG_IMAGE_RES = "image_res"
        private const val ARG_BG_COLOR = "bg_color"

        fun newInstance(title: String, description: String, imageRes: Int, backgroundColor: String): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle().apply {
                putString(ARG_TITLE, title)
                putString(ARG_DESCRIPTION, description)
                putInt(ARG_IMAGE_RES, imageRes)
                putString(ARG_BG_COLOR, backgroundColor)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(ARG_TITLE) ?: ""
        val description = arguments?.getString(ARG_DESCRIPTION) ?: ""
        val imageRes = arguments?.getInt(ARG_IMAGE_RES) ?: 0
        val backgroundColor = arguments?.getString(ARG_BG_COLOR) ?: "#FFFFFF"

        val titleTextView: TextView = view.findViewById(R.id.tvTitle)
        val descriptionTextView: TextView = view.findViewById(R.id.tvDescription)
        val imageView: ImageView = view.findViewById(R.id.ivOnboarding)
        val rootView: View = view.findViewById(R.id.rootView)

        titleTextView.text = title
        descriptionTextView.text = description
        if (imageRes != 0) {
            imageView.setImageResource(imageRes)
        }
        rootView.setBackgroundColor(Color.parseColor(backgroundColor))
    }
}