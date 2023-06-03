package com.example.mibus.schedule_editor_screen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mibus.databinding.FragmentScreenEditorScheduleBinding
import com.example.mibus.schedule_editor_screen.model.EditorScheduleModel
import com.example.mibus.schedule_editor_screen.model.EditorScheduleModelFactory
import com.example.mibus.model.StopPointData
import timber.log.Timber


const val TAG: String = " Thread 1" // Thread new

class ScreenEditorScheduleFragment : Fragment() {


   private val binding: FragmentScreenEditorScheduleBinding by lazy(LazyThreadSafetyMode.NONE) {
      FragmentScreenEditorScheduleBinding.inflate(layoutInflater)
   }

   private val args by navArgs<ScreenEditorScheduleFragmentArgs>()


   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      val application = requireNotNull(this.activity).application

      val viewModelFactory = EditorScheduleModelFactory(application)
      val mapBusListViewModel =
         ViewModelProvider(this, viewModelFactory)[EditorScheduleModel::class.java]

      //binding.detailListViewModel = mapBusListViewModel
      binding.lifecycleOwner = viewLifecycleOwner


      val text = binding.editSubTitle.text
      val title = binding.editTitle.text

      fun addDataTextEdit() {
         val list = arrayListOf<Double>()
       val mapPoint = StopPointData().also {
            it.latitude = text.toString().toDouble()
            it.longitude = title.toString().toDouble()
            it.title = "newPoint"
         }


        /* if (mapPoint.latitude == 0.0 || mapPoint.longitude == 0.0) {
            val mapPointis = StopPointData(2,1.0,1.0,"One")
            mapBusListViewModel.addPoint(mapPointis)
            Toast.makeText(application, "CREATE ITEM", Toast.LENGTH_SHORT).show()
         } else {
            val mapPointisNull = StopPointData(2,1.0,1.0,"One")
            Toast.makeText(application, "NOT Value", Toast.LENGTH_SHORT).show()

         }*/

         mapBusListViewModel.addPoint(mapPoint)
         Timber.tag(TAG).d("click")

      }
      binding.bottomDone.setOnClickListener {
         addDataTextEdit()
      }//(  Navigation.createNavigateOnClickListener(R.id.mapListFragment))

      binding.bottomDelete.setOnClickListener {
         mapBusListViewModel.deletePoint(args.currentPoint)
         findNavController().navigate(
            ScreenEditorScheduleFragmentDirections.actionScreenEditorScheduleFragmentIdToMapListFragment()
         )
      }

      mapBusListViewModel.navigateToMapPoint.observe(viewLifecycleOwner, Observer {
         if (it == true) {
            this.findNavController().navigate(
               ScreenEditorScheduleFragmentDirections.actionScreenEditorScheduleFragmentIdToMapListFragment()
            )
            mapBusListViewModel.doneNavigating()
         }
      }
      // Inflate the layout for this fragment
      return binding.root
   }


}





