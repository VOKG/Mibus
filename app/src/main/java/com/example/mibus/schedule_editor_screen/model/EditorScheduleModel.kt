package com.example.mibus.schedule_editor_screen.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mibus.schedule_list_screen.database.MapBusData
import com.example.mibus.schedule_list_screen.database.MapBusDataDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditorScheduleModel(
   private val mapPointKey: Long = 0L,
   dataSource: MapBusDataDao
) : ViewModel() {

   val dataBase = dataSource
   private val point = MediatorLiveData<MapBusData>()

   /////////////////////////////////////////////////////////////////////
   private var viewModelJob = Job()
   private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
   private var toCityPoint = MutableLiveData<MapBusData?>()

   /*-----------------------------------------------------------------------------------*/
   fun getPoint() = point

   init {
      point.addSource(dataBase.getCityWithId(mapPointKey), point::setValue)
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
   init {
      initializeToMapsCity()
   }

   override fun onCleared() {
      super.onCleared()
      viewModelJob.cancel()
   }

   private fun initializeToMapsCity() {
      uiScope.launch {
         toCityPoint.value = getMapCityFromDatabase()
      }
   }

   private suspend fun getMapCityFromDatabase(): MapBusData? {
      return withContext(Dispatchers.IO) {
         val city = dataBase.getTocity()
         /* if (city?.latitude != city?.longitude) {
              city = null
          }*/
         city
      }
   }


   fun onSetPointMap(pointCity: MapBusData) {
      uiScope.launch {
         insert(pointCity)

         toCityPoint.value = getMapCityFromDatabase()

      }
      // Setting this state variable to true will alert the observer and trigger navigation.
      _navigateToMapPoint.value = true
   }

   private suspend fun insert(point: MapBusData) {
      withContext(Dispatchers.IO) {
         dataBase.insert(point)

         toCityPoint.postValue(getMapCityFromDatabase())
         //refresh data
      }
   }

   fun deletePointMapCity(pointCity:Long) {
      uiScope.launch {
         delete(pointCity)

         toCityPoint.value = getMapCityFromDatabase()

      }
   }

   private suspend fun delete(pointCity: Long) {
      withContext(Dispatchers.IO) {
         dataBase.delete(pointCity)
      }
   }


}


