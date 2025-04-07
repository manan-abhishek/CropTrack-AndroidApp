package com.example.croptrack

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class ChooseCropLocation : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose_crop_location, container, false)

        val cropName = arguments?.getString("cropName")
        val cropNameTextView: TextView = view.findViewById(R.id.cropName)
        cropNameTextView.text = cropName

        val submitBtn: MaterialButton = view.findViewById(R.id.submitBtn)
        val location: TextInputLayout = view.findViewById(R.id.location)
        val fieldArea: TextInputLayout = view.findViewById(R.id.fieldArea)
        val err: TextView = view.findViewById(R.id.err)

        val area = fieldArea.editText?.text.toString()
        val loc = location.editText?.text.toString()

        submitBtn.setOnClickListener {
            val description = CropDescription().apply {
                arguments = Bundle().apply {
                    putString("cropName", cropName)
                    putString("area", area)
                    putString("location", loc)
                }
            }
            if(area != null && loc != null) {
                Toast.makeText(
                    requireContext(),
                    "your details: $area and $loc are saved",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                err.visibility = VISIBLE
                if(area == null){
                    fieldArea.boxStrokeColor = Color.parseColor("#f00")
                    fieldArea.boxStrokeWidth = 2
                }
                if(loc == null){
                    location.boxStrokeColor = Color.parseColor("#f00")
                    location.boxStrokeWidth = 2
                }
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, description)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}