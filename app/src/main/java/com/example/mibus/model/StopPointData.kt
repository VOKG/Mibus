package com.example.mibus.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "map_coordinate_city_table")
data class StopPointData(
    @PrimaryKey(autoGenerate = true)
    var mapId: Long = 0L,
    @ColumnInfo(name = "latitude")
    var latitude: Double = 0.0,
    @ColumnInfo(name = "longitude")
    var longitude: Double = 0.0,
    @ColumnInfo(name = "title")
    var title: String = ""
):Parcelable



