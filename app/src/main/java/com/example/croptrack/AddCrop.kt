package com.example.croptrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.card.MaterialCardView

class AddCrop : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cropsContainer: ConstraintLayout = requireView().findViewById(R.id.cropsContainer)

        for(i in 0 until cropsContainer.childCount) {
            val child = cropsContainer.getChildAt(i)
            if(child is MaterialCardView){
                child.setOnClickListener{
                    val name = child.tag?.toString() ?: "NULL"

                    val locationFrag = ChooseCropLocation().apply {
                        arguments = Bundle().apply{
                            putString("cropName", name)
                        }
                    }


                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment, locationFrag)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }

        return inflater.inflate(R.layout.fragment_add_crop, container, false)
    }
}