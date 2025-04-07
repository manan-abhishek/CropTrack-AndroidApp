package com.example.croptrack

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.croptrack.AddCrop
import com.example.croptrack.Climate
import com.example.croptrack.R
import com.example.croptrack.SoilTest

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val card1: View = view.findViewById(R.id.card1)
        val card2: View = view.findViewById(R.id.card2)
        val card3: View = view.findViewById(R.id.card3)
        val card4: View = view.findViewById(R.id.card4)
        val weatherCard: View = view.findViewById(R.id.weather_card)


        weatherCard.setOnClickListener {
            val climate = Climate()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, climate)
                .addToBackStack(null)
                .commit()
        }
        card1.setOnClickListener {
            val addCrops = AddCrop()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, addCrops)
                .addToBackStack(null)
                .commit()
        }
        card3.setOnClickListener {
            val soilTest = SoilTest()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, soilTest)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
