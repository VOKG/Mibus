package com.example.mibus.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import timber.log.Timber
import java.util.*

class BusViewModel: ViewModel() {

    private val callback:OnMapReadyCallback

    private lateinit var latLngList: MutableList<LatLng>

    private val _map = MutableLiveData<OnMapReadyCallback>()
    val map:LiveData<OnMapReadyCallback>
    get() = _map




    init {

         callback = OnMapReadyCallback { googleMap ->
             val nizhniyNovgorod =  LatLng(56.3, 44.0)
             googleMap.addMarker(
                 MarkerOptions().
                 position(nizhniyNovgorod).
                 title("Marker in Nizhniy-Novgorod")
             )
             googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nizhniyNovgorod, 12F))
             //setMapLongClick(googleMap)
            // setPointClick(googleMap)

         }

        //
        _map.value = callback


    }


    override fun onCleared() {
        super.onCleared()
        Timber.tag("ViewModel").i("Create View Model")

    }
    fun setPointClick(map:GoogleMap) {

        map.setOnPoiClickListener{
                point-> val pointMarker = map.addMarker(MarkerOptions().position(point.latLng).title(point.name))
        }


    }

    fun setMapLongClick(map: GoogleMap) {
        map.setOnMapClickListener {
            val snippet = String.format(Locale.getDefault(), "Lat: %1$.5f, Lng: %2$.5f", it.longitude, it.latitude)
            map.addMarker(MarkerOptions().position(it).title("2").snippet(snippet))
        }

    }



     fun mapPointList():LatLng{
        lateinit var newLan: LatLng
        latLngList = mutableListOf(
            LatLng(56.3, 44.0),
            LatLng(56.3, 43.0),
            LatLng(56.3, 42.0)
        )
        latLngList.shuffle()
  latLngList.forEach{  newLan = LatLng(it.latitude,it.longitude) }

               //  val pointMarker = map.addMarker(MarkerOptions().position(newLan.latLng).title(point.name))

        return newLan

    }


    fun nextPoint() {

        if (latLngList.isEmpty()) {

        } else {
             latLngList.removeAt(0)
            callback
        }
        Timber.i("next")
    }



}






