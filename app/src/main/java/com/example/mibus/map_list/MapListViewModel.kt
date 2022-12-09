package com.example.mibus.map_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mibus.database.MapBusData
import com.example.mibus.database.MapBusDataDao

class MapListViewModel( dataBase:MapBusDataDao,application: Application)
    :AndroidViewModel(application) {

    private var toDataMap = MutableLiveData<MapBusData?>()
    val mapBusCityPoint = dataBase.getAllCity()


}