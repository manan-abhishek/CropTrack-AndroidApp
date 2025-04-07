package com.example.croptrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class SoilTest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_soil_test, container, false)

        val soilTest: LinearLayout = view.findViewById(R.id.testSoil)
        val soilReport: LinearLayout = view.findViewById(R.id.soilReport)
// soiltest name change to soilData
        soilTest.setOnClickListener{
            val soildata = SoilData()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, soildata)
                .addToBackStack(null)
                .commit()
        }
        soilReport.setOnClickListener{
            val soilreport = SoilReport()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, soilreport)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}