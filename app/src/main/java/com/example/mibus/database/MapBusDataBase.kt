package com.example.mibus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MapBusData::class], version = 1, exportSchema = false)
abstract class MapBusDataBase:RoomDatabase() {

    abstract fun mapDatabasedao(): MapBusDataDao

    companion object{
        @Volatile
        private var INSTANCE:MapBusDataBase? = null

        fun getInstance(context:Context):MapBusDataBase {

            val instance = INSTANCE
            if (instance != null) {
                return instance
            }
                synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MapBusDataBase::class.java,
                    "city_base_map"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}