package com.example.mibus.schedule_update_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mibus.databinding.FragmentUpdateEditorBinding
import com.example.mibus.schedule_editor_screen.presentation.ScreenEditorScheduleFragmentArgs

class UpdateEditorFragment : Fragment() {
   private val binding: FragmentUpdateEditorBinding by lazy(LazyThreadSafetyMode.NONE) {
      FragmentUpdateEditorBinding.inflate(layoutInflater)
   }
   private val args by navArgs<ScreenEditorScheduleFragmentArgs>()



   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      val application = requireNotNull(this.activity).application
      val viewModelFactory = UpdateEditorModelFactory(application)

      binding.lifecycleOwner = viewLifecycleOwner

      args.idPoint


      // Inflate the layout for this fragment
      return binding.root
   }


}