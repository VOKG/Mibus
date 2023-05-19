package com.example.mibus.schedule_editor_screen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mibus.databinding.FragmentScreenEditorScheduleBinding
import com.example.mibus.schedule_editor_screen.model.EditorScheduleModel
import com.example.mibus.schedule_editor_screen.model.EditorScheduleModelFactory
import com.example.mibus.schedule_list_screen.database.MapBusData
import com.example.mibus.schedule_list_screen.database.MapBusDataBase
import timber.log.Timber


const val TAG: String = " Thread 1 "

class ScreenEditorScheduleFragment : Fragment() {


   private val binding: FragmentScreenEditorScheduleBinding by lazy(LazyThreadSafetyMode.NONE) {
      FragmentScreenEditorScheduleBinding.inflate(layoutInflater)
   }

   private val args: ScreenEditorScheduleFragmentArgs by navArgs()


   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      val application = requireNotNull(this.activity).application
      val arguments = args.pointIdKey
      fun argsReturn(): Long {
         val newValue: Long = 1
         if (arguments != null) {
            return arguments
         }
         return newValue
      }

      val dataSource = MapBusDataBase.getInstance(application).mapDatabasedao()
      val viewModelFactory = EditorScheduleModelFactory(argsReturn(), dataSource)
      val mapBusListViewModel =
         ViewModelProvider(this, viewModelFactory)[EditorScheduleModel::class.java]

      //binding.detailListViewModel = mapBusListViewModel
      binding.lifecycleOwner = viewLifecycleOwner

      val text = binding.editSubTitle.text
      val title = binding.editTitle.text

      fun addDataTextEdit() {

         val mapPoint = MapBusData().also {
            it.latitude = text.toString().toDouble()
            it.longitude = title.toString().toDouble()
            it.title = "newPoint"
         }
         mapBusListViewModel.onSetPointMap(mapPoint)

         Timber.tag(TAG).d("click")

      }
      binding.bottomDone.setOnClickListener {
         addDataTextEdit()
      }//(  Navigation.createNavigateOnClickListener(R.id.mapListFragment))

      binding.bottomDelete.setOnClickListener {
            mapBusListViewModel.deletePointMapCity(arguments)
      }

      mapBusListViewModel.navigateToMapPoint.observe(viewLifecycleOwner, Observer {
         if (it == true) {
            this.findNavController().navigate(
               ScreenEditorScheduleFragmentDirections.actionScreenEditorScheduleFragmentIdToMapListFragment()
            )
            mapBusListViewModel.doneNavigating()
         }
      })

      // Inflate the layout for this fragment
      return binding.root
   }


}





