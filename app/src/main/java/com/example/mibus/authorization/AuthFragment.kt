package com.example.mibus.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mibus.R
import com.example.mibus.databinding.FragmentAuthBinding


class AuthFragment : Fragment() {

    private val binding: FragmentAuthBinding by lazy(LazyThreadSafetyMode.NONE){
        FragmentAuthBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // val binding = DataBindingUtil.inflate<FragmentAuthBinding>(inflater,R.layout.fragment_auth, container, false)
/*сделать авторизацию и ввод пароля*/


        binding.btnAuth.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.userFragmentId))


        return binding.root
    }


}