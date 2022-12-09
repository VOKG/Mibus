package com.example.mibus.busmap

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mibus.KEY_REVENUE
import com.example.mibus.R
import com.example.mibus.ViewModel.BusViewModel
import com.example.mibus.databinding.FragmentMapsBinding
import com.google.android.gms.maps.SupportMapFragment
import timber.log.Timber


class MapsFragment : Fragment() {
    private lateinit var  busViewModel: BusViewModel

    private lateinit var binding: FragmentMapsBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
         binding = DataBindingUtil.inflate(inflater,
             R.layout.fragment_maps, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_Id) as SupportMapFragment

        busViewModel = ViewModelProvider(this)[BusViewModel::class.java]


        busViewModel.map.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            callback ->  mapFragment.getMapAsync(callback)

        })

        binding.btnMapData.setOnClickListener{ busViewModel.mapPointList()}


        binding.btnMapUserInfo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.userFragmentId))

      //  val toolbar = binding.mibusToolbar
      //  (requireActivity() as  AppCompatActivity).setSupportActionBar(toolbar)
        //val menuHost: MenuHost = requireActivity()

       // if (savedInstanceState != null){ val revenue =  savedInstanceState.getInt(KEY_REVENUE) }

        return binding.root
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Timber.i("onSaveInstanceStateMap")
    }
}