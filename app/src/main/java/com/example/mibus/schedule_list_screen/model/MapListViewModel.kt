package com.example.mibus.schedule_list_screen.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mibus.LiveDataDelegate
import com.example.mibus.Repository.MapBusRepository
import com.example.mibus.model.StopPointData
import com.example.mibus.database.StopPointDataBase

class MapListViewModel( application: Application) :
   AndroidViewModel(application) {

/******************************** initialization variables ***************************************/
  // private var toCityPoint = MutableLiveData<StopPointData?>()

   private val repository: MapBusRepository
   val readPointData: LiveData<List<StopPointData>>

   /******************************** button Event State ****************************************/

   init {
      val listPoints = StopPointDataBase.getInstance(application).stopPointDataDao()
      repository = MapBusRepository(listPoints)
      readPointData = repository.readAllData
   }



   /******************************** end button Event State **************************************/


   /**************************** initialization  MutableLiveData ********************/
   private val observeCity = LiveDataDelegate(StopPointData())//MutableLiveData<MapBusData>()
   var mapCity by observeCity
  // val mapCity: LiveData<MapBusData> get() = _mapCity

   private val observeSelectedItem = LiveDataDelegate(false)
   var selectedItem by observeSelectedItem
  // val selectedItem: LiveData<Boolean> get() = _selectedItem




}
