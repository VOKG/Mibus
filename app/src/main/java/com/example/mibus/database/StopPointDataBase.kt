package com.example.mibus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mibus.model.StopPointData

@Database(entities = [StopPointData::class], version = 1, exportSchema = false)
abstract class StopPointDataBase:RoomDatabase() {

    abstract fun stopPointDataDao(): StopPointDataDao

    companion object{
        @Volatile
        private var INSTANCE: StopPointDataBase? = null

        fun getInstance(context:Context): StopPointDataBase {

            val instance = INSTANCE
            if (instance != null) {
                return instance
            }
                synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StopPointDataBase::class.java,
                    "city_base_map"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}