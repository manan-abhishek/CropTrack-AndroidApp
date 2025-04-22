package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EquipmentListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var equipmentAdapter: EquipmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_equipment_list, container, false)

        recyclerView = view.findViewById(R.id.rvEquipment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Dummy data for now
        val equipmentList = listOf(
            Equipment("Tractor", "Used for farming", R.drawable.img),
            Equipment("Plow", "Used for plowing", R.drawable.img_2),
            Equipment("Seeder", "Used for seeding", R.drawable.img_3)
        )
        equipmentAdapter = EquipmentAdapter(equipmentList)

        recyclerView.adapter = equipmentAdapter

        return view
    }
}
