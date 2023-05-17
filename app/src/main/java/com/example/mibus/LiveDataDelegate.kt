package com.example.mibus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlin.reflect.KProperty


class LiveDataDelegate<T> (
   private val default:T,
   private val liveData: MutableLiveData<T?> = MutableLiveData()
   ){

   init {
      liveData.value = default
   }

   operator fun getValue(thisRef:Any, properties: KProperty<*>) = liveData.value ?:default
   operator fun setValue(thisRef:Any, properties: KProperty<*>, value:T){
      liveData.value = value
   }
   fun observe(owner:LifecycleOwner, observe:(T)-> Unit) =liveData.observe(owner, Observer {
      if (it != null) {
         observe(it)
      }
   })


}