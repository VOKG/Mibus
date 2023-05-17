package com.example.mibus

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mibus.schedule_list_screen.database.MapBusData

@BindingAdapter("mapCityTitle")
fun EditText.setCityTitleString(item: MapBusData?) {
    if (item != null) {
        item.title = text.toString()
    }

}
@BindingAdapter("mapCityLatitude")
fun TextView.setCityLatitudeString(item: MapBusData?){
    if (item != null) {
        item.latitude = text.toString().toDouble()
    }
}

@BindingAdapter("mapCityLongitude")
fun TextView.setCityLongitudeString(item: MapBusData?){
    if (item != null) {
        item.longitude = text.toString().toDouble()
    }

}





