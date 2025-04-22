package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class BookingFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_booking_form, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Retrieve arguments from the Bundle
        val equipmentName = arguments?.getString("name") ?: ""
        val equipmentImage = arguments?.getInt("image") ?: 0

        // Set values to the UI components
        view.findViewById<TextView>(R.id.tvSelectedEquipment).text = equipmentName
        view.findViewById<ImageView>(R.id.imgSelectedEquipment)
            .setImageResource(equipmentImage)

        // Handle the Submit Booking button click
        view.findViewById<Button>(R.id.btnSubmitBooking).setOnClickListener {
            val userName = view.findViewById<EditText>(R.id.etName).text.toString().trim()
            val date = view.findViewById<EditText>(R.id.etDate).text.toString().trim()

            if (userName.isEmpty() || date.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Booking Submitted!", Toast.LENGTH_LONG).show()
                parentFragmentManager.popBackStack()
            }
        }
    }
}
