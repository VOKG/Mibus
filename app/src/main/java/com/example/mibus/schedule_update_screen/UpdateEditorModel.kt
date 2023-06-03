package com.example.mibus.schedule_update_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.mibus.LiveDataDelegate
import com.example.mibus.Repository.MapBusRepository
import com.example.mibus.database.StopPointDataBase
import com.example.mibus.model.StopPointData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateEditorModel
   (
   application: Application
) : AndroidViewModel(application) {

   private val point = MediatorLiveData<StopPointData>()
   private val repository: MapBusRepository // fun getPoint() = poinr
   fun getPoint() = point

   init {
      val listPoints = StopPointDataBase.getInstance(application).stopPointDataDao()
      repository = MapBusRepository(listPoints) // переименовать

   }

   fun deletePoint(point:StopPointData){
      viewModelScope.launch(Dispatchers.IO) {
         repository.deletePoint(point)
      }
   }
}