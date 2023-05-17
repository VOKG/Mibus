package com.example.mibus.schedule_list_screen.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "map_coordinate_city_table")
data class MapBusData(
    @PrimaryKey(autoGenerate = true)
    var mapId: Long = 0L,
    @ColumnInfo(name = "latitude")
    var latitude: Double = 0.0,
    @ColumnInfo(name = "longitude")
    var longitude: Double = 0.0,
    @ColumnInfo(name = "title")
    var title: String = ""
)



