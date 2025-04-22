package com.example.croptrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MyBookingsFragment : Fragment() {

    // same data class
    data class Booking(val equipmentName: String, val bookingDate: String)

    // same “fetch” logic
    private fun getBookings(): List<Booking> = listOf(
        Booking("Tractor", "2025-04-16"),
        Booking("Combine Harvester", "2025-04-17"),
        Booking("Plough", "2025-04-18")
        // …add more here
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_bookings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookings = getBookings()
        val bookingDescriptions = bookings.map { "${it.equipmentName} on ${it.bookingDate}" }

        val listView = view.findViewById<ListView>(R.id.lvBookings)

        val adapter = ArrayAdapter(
            requireContext(),
            R.layout.list_item_booking,
            R.id.itemBookingInfo,
            bookingDescriptions
        )
        listView.adapter = adapter
    }
}
