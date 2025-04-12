package com.example.croptrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Rent : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rent, container, false)

        // Get reference to MainActivity
        val mainActivity = activity as? MainActivity

        // Call open() to update toolbar
        mainActivity?.open(
            mainActivity.getRentIcon(),
            mainActivity.getRentText()
        )

        return view
    }
}