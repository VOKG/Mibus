package com.example.mibus.busmap_screen

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mibus.R
import com.example.mibus.ViewModel.BusViewModel
import com.example.mibus.databinding.FragmentMapsBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.layout_persistent_bottom_sheet.*
import timber.log.Timber


class MapsFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

   private lateinit var binding: FragmentMapsBinding
   private lateinit var map: GoogleMap
   private lateinit var mapCurrentLocation: Location
   private lateinit var mapFragment: SupportMapFragment
   private lateinit var callback: OnMapReadyCallback

   //  private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      binding = DataBindingUtil.inflate(
         inflater,
         R.layout.fragment_maps, container, false
      )
      val application = requireNotNull(this.activity).application

      return binding.root
      /********************************** end onCreateView ********************************/
   }

   /********************************** Start setupMapIfNeeded ********************************/
   private fun setupMapIfNeeded() {
      mapFragment = childFragmentManager.findFragmentById(R.id.map_Id) as SupportMapFragment

      if (mapFragment != null) {
         mapFragment.getMapAsync(this)
      }


      /********************************** end setupMapIfNeeded ********************************/
   }

   override fun onMapReady(map: GoogleMap) {

   }

   override fun onMarkerClick(marker: Marker): Boolean {
      return false
   }

   override fun onSaveInstanceState(outState: Bundle) {
      super.onSaveInstanceState(outState)
      //if(){}

      Timber.i("onSaveInstanceStateMap")
   }


   /********************************** Start bottomSheetBehavior ********************************/
   /* bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetMap)

     bottomSheetBehavior.addBottomSheetCallback(object :
        BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(bottomSheet: View, newState: Int) {
           when (newState) {
              BottomSheetBehavior.STATE_COLLAPSED ->
                 Toast.makeText(application, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
              BottomSheetBehavior.STATE_EXPANDED ->
                 Toast.makeText(application, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
              BottomSheetBehavior.STATE_DRAGGING ->
                 Toast.makeText(application, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
              BottomSheetBehavior.STATE_SETTLING ->
                 Toast.makeText(application, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
              BottomSheetBehavior.STATE_HIDDEN ->
                 Toast.makeText(application,"STATE_HIDDEN", Toast.LENGTH_SHORT).show()

              else -> Toast.makeText(application, "OTHER_STATE", Toast.LENGTH_SHORT).show()
           }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
           // handle onSlide
        }
     })*/

   /***************************** End bottomSheetBehavior ***************************************/


   //binding.btnMapData.setOnClickListener { busViewModel.mapPointList() }


   //binding.btnMapUserInfo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.userFragmentId))

   //  val toolbar = binding.mibusToolbar
   //  (requireActivity() as  AppCompatActivity).setSupportActionBar(toolbar)
   //val menuHost: MenuHost = requireActivity()

   // if (savedInstanceState != null){ val revenue =  savedInstanceState.getInt(KEY_REVENUE) }


   /////////////////////////////////////////////////////////////////////////////////////////////////


}