package com.example.mibus.schedule_update_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import com.example.mibus.LiveDataDelegate
import com.example.mibus.Repository.MapBusRepository
import com.example.mibus.database.StopPointDataBase
import com.example.mibus.model.StopPointData

class UpdateEditorMod
   (
   private val pointId: Long = 0L, application: Application
) : AndroidViewModel(application) {

   private val point = MediatorLiveData<StopPointData>()
   private val repository: MapBusRepository // fun getPoint() = poinr

   init {
      val listPoints = StopPointDataBase.getInstance(application).stopPointDataDao()
      repository = MapBusRepository(listPoints) // переименовать
      // readAllData = repository.readAllData
      point.addSource(
         //  readPointData = repository.getPointId()
         repository.getPointId(pointId), point::setValue
      )//getCityWithId(mapPointKey), point::setValue*/
   }

}