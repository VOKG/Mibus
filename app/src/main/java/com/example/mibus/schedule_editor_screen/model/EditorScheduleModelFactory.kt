package com.example.mibus.schedule_editor_screen.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditorScheduleModelFactory(
   private val application: Application
) : ViewModelProvider.Factory {
   @Suppress("unchecked_cast")
   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(EditorScheduleModel::class.java)) {
         return EditorScheduleModel( application) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
   }


}