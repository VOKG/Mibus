package com.example.mibus.schedule_update_screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mibus.model.StopPointData
import com.example.mibus.schedule_editor_screen.model.EditorScheduleModel

class UpdateEditorModelFactory(
   private val application: Application
):ViewModelProvider.Factory
{
   @Suppress("unchecked_cast")
   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(UpdateEditorModel::class.java)) {
         return UpdateEditorModel( application) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
   }




}