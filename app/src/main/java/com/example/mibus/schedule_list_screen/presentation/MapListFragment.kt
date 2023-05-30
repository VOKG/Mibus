package com.example.mibus.schedule_list_screen.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mibus.R
import com.example.mibus.databinding.FragmentMapListBinding
import com.example.mibus.schedule_list_screen.MapListAdapter
import com.example.mibus.schedule_list_screen.MapListListener
import com.example.mibus.database.StopPointDataBase
import com.example.mibus.schedule_list_screen.model.MapListViewModel
import com.example.mibus.schedule_list_screen.model.MapListViewModelFactory

/*Start class MapListFragment*/
class MapListFragment : Fragment() {

   /***************************** lazy initialization binding *************************************/
   private val binding: FragmentMapListBinding by lazy(LazyThreadSafetyMode.NONE) {
      FragmentMapListBinding.inflate(layoutInflater)
   } // lazy initialization binding


   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {

      /* val binding: FragmentMapListBinding = DataBindingUtil.inflate(
           inflater, R.layout.fragment_map_list, container, false
        )*/
      /*****************************  initialization MapBusDataBase ******************************/
      val application = requireNotNull(this.activity).application
      //val dataSource = StopPointDataBase.getInstance(application).mapDatabasedao()
      val viewModelFactory = MapListViewModelFactory(application)
      val mapBusListViewModel =
         ViewModelProvider(this, viewModelFactory)[MapListViewModel::class.java]

      binding.mapBusListViewModel = mapBusListViewModel
      binding.lifecycleOwner = viewLifecycleOwner
      /***************************** End initialization MapBusDataBase ***************************/

      /******************************* Start DividerItemDecoration *******************************/
      /* binding.mapListPointCity.addItemDecoration(
        DividerItemDecoration(this.context,DividerItemDecoration.VERTICAL).apply {
           setDrawable()
        }
     )*/

      binding.mapListPointCity.apply {
         setHasFixedSize(true)
         val item: Drawable = ContextCompat.getDrawable(this.context, R.drawable.draw_divider) as Drawable

         val dividerDecoration = DividerItemDecorationLastExcluded(item)
            //DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)

         addItemDecoration(dividerDecoration)
      }
      /****************************** End DividerItemDecoration ***********************************/

      /********************************* Start Adapter *******************************************/
      val adapter = MapListAdapter(MapListListener { cityId ->
         Toast.makeText(context, "${cityId}", Toast.LENGTH_LONG).show()
      })
      binding.mapListPointCity.adapter = adapter

      mapBusListViewModel.readPointData.observe(viewLifecycleOwner) {
         it?.let {
            adapter.submitList(it) // заполнение данными лист
         }
      }
      /********************************** End Adapter ********************************************/
      /////////////////////////////////////////////////////////////////////////////////////////////
      /********************************* Start BottomSheetDialog *********************************/

      binding.bottomSheetShow.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.screenEditorScheduleFragmentId))
      /*val dialog = this.context?.let { BottomSheetDialog(it) } // BottomSheetDialog
       val sheetBinding: ScheduleBottomSheetBinding =
          ScheduleBottomSheetBinding.inflate(layoutInflater, null, false)


       if (dialog != null) {
          dialog.setContentView(sheetBinding.root)
          dialog.show()
       }
       sheetBinding.newElementButton.setOnClickListener {
          mapBusListViewModel.addPointMapCity()
       }
       sheetBinding.clearButton.setOnClickListener {
          mapBusListViewModel.onClear()
       }
       */

      /********************************** End BottomSheetDialog **********************************/


      return binding.root
   }


}