package com.gosiewski.taxiappandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        private val INTENT_ARG_LAT = "intent.lat"
        private val INTENT_ARG_LANG = "intent.lang"

        fun newInstance(context: Context, lat: Double, lang: Double): Intent {
            val intent = Intent(context, MapActivity::class.java)

            intent.putExtra(INTENT_ARG_LAT, lat)
            intent.putExtra(INTENT_ARG_LANG, lang)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val order = LatLng(intent.getDoubleExtra(INTENT_ARG_LAT, 0.0), intent.getDoubleExtra(INTENT_ARG_LANG, 0.0))
        mMap.addMarker(MarkerOptions().position(order).title("Order location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(order))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(12.0F))
    }
}
