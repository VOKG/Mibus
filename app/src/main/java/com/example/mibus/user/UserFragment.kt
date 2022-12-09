package com.example.mibus.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mibus.R
import com.example.mibus.databinding.FragmentUserBinding


class UserFragment : Fragment() {

    private val binding:FragmentUserBinding by lazy(LazyThreadSafetyMode.NONE){
        FragmentUserBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // val binding = DataBindingUtil.inflate<FragmentUserBinding>(inflater, R.layout.fragment_user, container, false)

        binding.btnUserEvent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mapFragmentId))
        binding.btnUserEventList.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mapListFragment))

        return binding.root
    }


}