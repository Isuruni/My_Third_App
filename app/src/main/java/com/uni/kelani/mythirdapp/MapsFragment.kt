package com.uni.kelani.mythirdapp

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.uni.kelani.mythirdapp.database.AppDatabase

class MapsFragment(lName:String, latitude:Double, longitude:Double): Fragment() {


    private val callback = OnMapReadyCallback { googleMap ->


        val location = LatLng(latitude, longitude)
        googleMap.setMinZoomPreference(14.0f)
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        googleMap.addMarker(MarkerOptions().position(location).title(""""Marker in $lName"""))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val db= AppDatabase.getDatabase(view.context)
       // db.locationsDao()
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}