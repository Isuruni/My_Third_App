package com.uni.kelani.mythirdapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Locations(
    @PrimaryKey val uid: Int,
    val location_name: String?,
    val latitude: Float?,
    val longitude: Float?
)