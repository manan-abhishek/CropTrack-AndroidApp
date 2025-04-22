package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class EquipmentAdapter(
    private val equipmentList: List<Equipment>
) : RecyclerView.Adapter<EquipmentAdapter.EquipmentViewHolder>() {

    class EquipmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val equipmentImage: ImageView = view.findViewById(R.id.equipmentImage)
        val equipmentName: TextView = view.findViewById(R.id.equipmentName)
        val equipmentDescription: TextView = view.findViewById(R.id.equipmentDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipment, parent, false)
        return EquipmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: EquipmentViewHolder, position: Int) {
        val equipment = equipmentList[position]
        holder.equipmentName.text = equipment.name
        holder.equipmentDescription.text = equipment.description
        holder.equipmentImage.setImageResource(equipment.imageResId)

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("name", equipment.name)
                putString("description", equipment.description)
                putInt("image", equipment.imageResId)
            }

            it.findNavController().navigate(
                R.id.action_equipmentListFragment_to_equipmentDetailsFragment,
                bundle
            )
        }
    }

    override fun getItemCount() = equipmentList.size
}
