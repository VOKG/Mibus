package com.example.mibus.map_list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mibus.database.MapBusDataDao


class MapListViewModelFactory(private val dataSource: MapBusDataDao,
                              private val application: Application)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapListViewModel::class.java)) {
            return MapListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}