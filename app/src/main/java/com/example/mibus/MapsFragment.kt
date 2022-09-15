package com.example.mibus

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mibus.ViewModel.ViewModel
import com.example.mibus.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class MapsFragment : Fragment(), ViewModel {
 //   private lateinit var mMap: GoogleMap

   private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        setMapLongClick(googleMap)
        setPointClick(googleMap)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = DataBindingUtil.inflate<FragmentMapsBinding>(inflater,R.layout.fragment_maps, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_Id) as SupportMapFragment
        mapFragment.getMapAsync(callback)
        binding.btnMapUserInfo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.userFragmentId))
        val toolbar = binding.mibusToolbar
        (requireActivity() as  AppCompatActivity).setSupportActionBar(toolbar)

        val menuHost: MenuHost = requireActivity()



        return binding.root
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setPointClick(map:GoogleMap) {
        map.setOnPoiClickListener{
                point-> val pointMarker = map.addMarker(MarkerOptions().position(point.latLng).title(point.name))
        }

    }

    override fun setMapLongClick(map: GoogleMap) {
        map.setOnMapClickListener {
            val snippet = String.format(Locale.getDefault(), "Lat: %1$.5f, Lng: %2$.5f", it.longitude, it.latitude)
            map.addMarker(MarkerOptions().position(it).title("1").snippet(snippet))
        }

    }

}