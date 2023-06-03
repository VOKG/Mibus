package com.example.mibus.schedule_update_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mibus.databinding.FragmentUpdateEditorBinding
import com.example.mibus.schedule_editor_screen.presentation.ScreenEditorScheduleFragmentArgs

class UpdateEditorFragment : Fragment() {

   private val binding: FragmentUpdateEditorBinding by lazy(LazyThreadSafetyMode.NONE) {
      FragmentUpdateEditorBinding.inflate(layoutInflater)
   }
   private val args by navArgs<UpdateEditorFragmentArgs>()


   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
   ): View? {
      binding.textTitle.text = args.currentPoint.title
      binding.textTwo.text = args.currentPoint.latitude.toString()
      binding.textThree.text = args.currentPoint.longitude.toString()



      val application = requireNotNull(this.activity).application
      val viewModelFactory = UpdateEditorModelFactory(application)
      val viewModel = ViewModelProvider(this,viewModelFactory)[UpdateEditorModel::class.java]

      binding.lifecycleOwner = viewLifecycleOwner
        // Update point
      binding.btnUpdate.setOnClickListener { }
      // Delete point
      binding.btnDelete.setOnClickListener {
         Toast.makeText(context, "${args.currentPoint}", Toast.LENGTH_LONG).show()
         viewModel.deletePoint(args.currentPoint)
      }



      // Inflate the layout for this fragment
      return binding.root
   }


}