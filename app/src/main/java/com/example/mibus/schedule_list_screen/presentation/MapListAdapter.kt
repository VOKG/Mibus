package com.example.mibus.schedule_list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mibus.R
import com.example.mibus.model.StopPointData
import com.example.mibus.databinding.ListItemCityBinding


class MapListAdapter(private val clickListener: MapListListener) :
   ListAdapter<StopPointData, MapListAdapter.ViewHolder>(MapListDiffCallback()) {

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item = getItem(position)
      holder.bind(clickListener, item)

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder.from(parent)
   }


   class ViewHolder private constructor(val binding: ListItemCityBinding) :
      RecyclerView.ViewHolder(binding.root) {

      fun bind(clickListener: MapListListener, item: StopPointData) {
         binding.city = item
         binding.clickListener = clickListener
         binding.textView4.text = item.latitude.toString()
         binding.textView.text = item.latitude.toString()
         binding.imageView3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.screenEditorScheduleFragmentId))

      }

      companion object {
         fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemCityBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)

         }
      }

   }

}

class MapListDiffCallback : DiffUtil.ItemCallback<StopPointData>() {

   override fun areItemsTheSame(oldItem: StopPointData, newItem: StopPointData): Boolean {
      return oldItem.mapId == newItem.mapId
   }

   override fun areContentsTheSame(oldItem: StopPointData, newItem: StopPointData): Boolean {
      return oldItem == newItem
   }
}

class MapListListener(val clickListener: (itemView: Long) -> Unit) {
   fun onClick(city: StopPointData) = clickListener(city.mapId)
}




