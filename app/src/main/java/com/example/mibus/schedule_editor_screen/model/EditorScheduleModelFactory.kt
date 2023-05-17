package com.example.mibus.schedule_editor_screen.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mibus.schedule_list_screen.database.MapBusDataDao

class EditorScheduleModelFactory(
   private val mapPointKey: Long,
   private val dataSource:MapBusDataDao
):ViewModelProvider.Factory {
   @Suppress("unchecked_cast")
   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if(modelClass.isAssignableFrom(EditorScheduleModel::class.java)){
         return EditorScheduleModel(mapPointKey,dataSource) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
   }
}