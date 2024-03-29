package com.example.mibus.schedule_list_screen.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MapListViewModelFactory(
   private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapListViewModel::class.java)) {
            return MapListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}