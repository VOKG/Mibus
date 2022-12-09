package com.example.mibus.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface MapBusDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert (city: MapBusData)
    @Update
    fun update (city: MapBusData)
    @Query("SELECT * from map_coordinate_city_table WHERE mapId = :key")
    fun get (key:Long):MapBusData?
    @Query("DELETE FROM map_coordinate_city_table")
    fun clear()
    @Query("SELECT * from map_coordinate_city_table ORDER BY mapId DESC")
    fun getAllCity(): LiveData<List<MapBusData>>
    @Query("SELECT * FROM  map_coordinate_city_table ORDER BY mapId DESC LIMIT 1")
    fun getTocity(): MapBusData?
    @Query("SELECT * from map_coordinate_city_table WHERE mapId = :key")
    fun getCityWithId(key: Long): LiveData<MapBusData>
}