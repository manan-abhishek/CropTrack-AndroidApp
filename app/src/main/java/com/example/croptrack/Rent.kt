package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Rent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_rent, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            android.util.Log.d("NavTrace", "Navigated to ${destination.label} (${destination.id})")
        }

        val items = listOf(
            Triple(R.id.itemTractor, "Tractor", R.drawable.img),
            Triple(R.id.itemCombine, "Combine Harvester", R.drawable.img_1),
            Triple(R.id.itemPlough, "Plough", R.drawable.img_2),
            Triple(R.id.itemRotavator, "Rotavator", R.drawable.img_3),
            Triple(R.id.itemSeeder, "Seeder", R.drawable.img_4),
            Triple(R.id.itemSprayer, "Sprayer", R.drawable.img_5),
            Triple(R.id.itemBaler, "Baler", R.drawable.img_6),
            Triple(R.id.itemIrrigation, "Irrigation System", R.drawable.img_7),
            Triple(R.id.itemMiniLoader, "Mini Loader", R.drawable.img_8)
        )

        items.forEach { (viewId, name, imageResId) ->
            view.findViewById<LinearLayout>(viewId).setOnClickListener {
                launchDetail(name, getDescription(name), imageResId)
            }
        }

        view.findViewById<Button>(R.id.btnMyBookings).setOnClickListener {
            if (navController.currentDestination?.id == R.id.rent) {
                navController.navigate(R.id.action_rent_to_myBookingsFragment)
            }
        }
    }

    private fun getDescription(name: String): String {
        return when (name) {
            "Tractor" -> "A powerful tractor for heavy lifting."
            "Combine Harvester" -> "Efficient machine for harvesting various crops."
            "Plough" -> "Used to prepare soil for sowing by turning it over."
            "Rotavator" -> "Rotary tiller ideal for breaking up soil."
            "Seeder" -> "Sows seeds evenly and efficiently across the field."
            "Sprayer" -> "Applies pesticides or fertilizers over crops."
            "Baler" -> "Compacts hay or straw into manageable bales."
            "Irrigation System" -> "Provides controlled water supply to crops."
            "Mini Loader" -> "Versatile machine for moving soil and materials."
            else -> "No description available."
        }
    }

    private fun launchDetail(name: String, description: String, imageResId: Int) {
        val bundle = Bundle().apply {
            putString("name", name)
            putString("description", description)
            putInt("imageResId", imageResId)
        }

        val navController = findNavController()
        val currentDestinationId = navController.currentDestination?.id

        if (currentDestinationId == R.id.rent) {
            navController.navigate(R.id.action_rent_to_equipmentDetailsFragment, bundle)
        } else {
            android.util.Log.w("NavSafe", "Navigation failed: current destination is not Rent")
        }
    }
}
