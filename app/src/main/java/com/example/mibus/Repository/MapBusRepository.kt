package com.example.mibus.Repository

import androidx.lifecycle.LiveData
import com.example.mibus.model.StopPointData
import com.example.mibus.database.StopPointDataDao

class MapBusRepository(val mapBusDao: StopPointDataDao) {

   val readAllData: LiveData<List<StopPointData>> = mapBusDao.getAllPoint()


   suspend fun addPoint(point: StopPointData){
      mapBusDao.insert(point)
   }

   suspend fun updatePoints(point: StopPointData){
      mapBusDao.update(point)
   }

   suspend fun deletePoint(point: StopPointData){
      mapBusDao.delete(point)
   }

   suspend fun deleteAllPoints(){
      mapBusDao.clear()
   }

 fun getPointId(key:Long):LiveData<StopPointData>{
     return mapBusDao.getPointWithId(key)
   }




}