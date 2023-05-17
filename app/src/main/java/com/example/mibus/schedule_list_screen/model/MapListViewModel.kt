package com.example.mibus.schedule_list_screen.model

import android.app.Application
import androidx.lifecycle.*
import com.example.mibus.LiveDataDelegate
import com.example.mibus.schedule_list_screen.database.MapBusData
import com.example.mibus.schedule_list_screen.database.MapBusDataDao
import kotlinx.coroutines.*

class MapListViewModel(val dataBase: MapBusDataDao, application: Application) :
   AndroidViewModel(application) {

/******************************** initialization variables ***************************************/
   private var viewModelJob = Job()
   private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
   private var toCityPoint = MutableLiveData<MapBusData?>()

   val mapCityPoints = dataBase.getAllCity()
   /******************************** button Event State ****************************************/
   val clearbutton = Transformations.map(mapCityPoints) {

      it?.isNotEmpty()
   }
   val newCityButton = Transformations.map(toCityPoint) {
      null == it
   }



   /******************************** end button Event State **************************************/
   
   /******************************** hardcode data value ****************************************/
   val pointCity = MapBusData(0L, 100.2, 200.3, "Moscow \n")

   /**************************** initialization  MutableLiveData ********************/
   private val observeCity = LiveDataDelegate<MapBusData>(MapBusData())//MutableLiveData<MapBusData>()
   var mapCity by observeCity
  // val mapCity: LiveData<MapBusData> get() = _mapCity

   private val observeSelectedItem = LiveDataDelegate<Boolean>(false)
   var selectedItem by observeSelectedItem
  // val selectedItem: LiveData<Boolean> get() = _selectedItem


   init {
      initializeToMapsCity()
   }
   /******************************** fun onCleared ***********************************************/
   override fun onCleared() {
      super.onCleared()
      viewModelJob.cancel()
   }
   /********************************** end fun onCleared *****************************************/

   /**************************** Coroutine initialize value  toCityPoint ********************/
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
   /**************************** end Coroutine initialize value  toCityPoint ********************/

  /**************************** Coroutine insert value toCityPoint ********************/

   fun addPointMapCity(pointCity:MapBusData) {
      uiScope.launch {
         insert(pointCity)

         toCityPoint.value = getMapCityFromDatabase()

      }
   }

   private suspend fun insert(point: MapBusData) {
      withContext(Dispatchers.IO) {
         dataBase.insert(point)

         toCityPoint.postValue(getMapCityFromDatabase())
            //refresh data
      }
   }

   /**************************** End Coroutine insert value toCityPoint ********************/

   /**************************** Coroutine onClear value toCityPoint ********************/

   fun onClear() {
      uiScope.launch {
         clear()
         toCityPoint.value = null
      }
   }

   private suspend fun clear() {
      withContext(Dispatchers.IO) {
         dataBase.clear()
      }
   }
   /*************************** End Coroutine insert value toCityPoint ********************/

   fun deletePointMapCity(pointCity:MapBusData) {
      uiScope.launch {
        delete(pointCity)

         toCityPoint.value = getMapCityFromDatabase()

      }
   }

   private suspend fun delete(pointCity: MapBusData) {
      withContext(Dispatchers.IO) {
         dataBase.delete(pointCity.mapId)
      }
   }

}
