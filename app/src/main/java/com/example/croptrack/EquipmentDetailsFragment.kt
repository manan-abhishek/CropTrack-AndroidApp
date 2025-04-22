package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EquipmentDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_equipment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name") ?: ""
        val description = arguments?.getString("description") ?: ""
        val imageResId = arguments?.getInt("image") ?: 0

        view.findViewById<TextView>(R.id.equipmentName).text = name
        view.findViewById<TextView>(R.id.equipmentDescription).text = description
        view.findViewById<ImageView>(R.id.equipmentImage).setImageResource(imageResId)

        view.findViewById<Button>(R.id.btnBookEquipment).setOnClickListener {
            val bundle = Bundle().apply {
                putString("name", name)
                putInt("imageResId", imageResId) // BookingForm expects this key
            }

            findNavController().navigate(R.id.action_equipmentDetailsFragment_to_bookingFormFragment, bundle)
        }
    }
}
