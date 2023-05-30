package com.example.mibus.schedule_editor_screen.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mibus.Repository.MapBusRepository
import com.example.mibus.model.StopPointData
import com.example.mibus.database.StopPointDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditorScheduleModel(
   application: Application
) : AndroidViewModel(application) {

   // val dataBase = dataSource
   // val readAllData: LiveData<List<StopPointData>>
   private val _readPointData = MutableLiveData<StopPointData>()
   val readPointData: LiveData<StopPointData>
      get()=_readPointData

   private val repository: MapBusRepository


   /////////////////////////////////////////////////////////////////////
   private var toCityPoint = MutableLiveData<StopPointData?>()

   /*-----------------------------------------------------------------------------------*/


   init {
      val listPoints = StopPointDataBase.getInstance(application).stopPointDataDao()
      repository = MapBusRepository(listPoints) // переименовать
      // readAllData = repository.readAllData
    //  readPointData = repository.getPointId()
   }

   private val _navigateToMapPoint = MutableLiveData<Boolean?>()
   val navigateToMapPoint: LiveData<Boolean?>
      get() = _navigateToMapPoint


   fun doneNavigating() {
      _navigateToMapPoint.value = null
   }

   fun onClose() {
      _navigateToMapPoint.value = true
   }

   //-------------start coroutine-------------------------------* //
   fun addPoint(point: StopPointData) {
      viewModelScope.launch(Dispatchers.IO) {
         repository.addPoint(point)
      }
      _navigateToMapPoint.value = true
   }


   fun updatePoints(point: StopPointData) {
      viewModelScope.launch(Dispatchers.IO) {
         repository.updatePoints(point)
      }
   }

   fun deletePoint(point: StopPointData) {
      viewModelScope.launch(Dispatchers.IO) {
         repository.deletePoint(point)
      }
   }

   fun deleteAllPoints() {
      viewModelScope.launch(Dispatchers.IO) {
         repository.deleteAllPoints()
      }
   }


}


