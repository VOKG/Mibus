package com.example.mibus

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mibus.model.StopPointData

@BindingAdapter("mapCityTitle")
fun TextView.setCityTitleString(item: StopPointData?) {
    if (item != null) {
        item.title = text.toString()
    }

}
@BindingAdapter("mapCityLatitude")
fun TextView.setCityLatitudeString(item: StopPointData?){
    if (item != null) {
        item.latitude = text.toString().toDouble()
    }
}

@BindingAdapter("mapCityLongitude")
fun TextView.setCityLongitudeString(item: StopPointData?){
    if (item != null) {
        item.longitude = text.toString().toDouble()
    }

}





