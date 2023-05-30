package com.example.mibus.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mibus.model.StopPointData


@Dao
interface StopPointDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (point: StopPointData)
    @Update
    fun update (point: StopPointData)
    @Query("SELECT * from map_coordinate_city_table WHERE mapId = :key")
    fun get (key:Long): StopPointData?
    @Query("DELETE FROM map_coordinate_city_table")
    fun clear()
    @Delete
    fun delete(point: StopPointData)
    @Query("SELECT * from map_coordinate_city_table ORDER BY mapId DESC")
    fun getAllPoint(): LiveData<List<StopPointData>>
    @Query("SELECT * FROM  map_coordinate_city_table ORDER BY mapId DESC LIMIT 1")
    fun getTocity(): StopPointData?
    @Query("SELECT * from map_coordinate_city_table WHERE mapId = :key")
    fun getPointWithId(key: Long): LiveData<StopPointData>
}