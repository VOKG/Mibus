package com.example.mibus.map_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mibus.R
import com.example.mibus.database.MapBusDataBase
import com.example.mibus.databinding.FragmentMapListBinding

class MapListFragment:Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentMapListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_map_list,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = MapBusDataBase.getInstance(application).mapDatabasedao()
        val viewModelFactory = MapListViewModelFactory(dataSource, application)
        val mapBusListViewModel = ViewModelProvider(this, viewModelFactory)[MapListViewModel::class.java]
        binding.mapBusListViewModel = mapBusListViewModel
        binding.lifecycleOwner = this














        return binding.root
    }
}