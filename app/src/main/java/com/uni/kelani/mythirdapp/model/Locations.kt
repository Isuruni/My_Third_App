package com.uni.kelani.mythirdapp.model

import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Locations(
    @PrimaryKey val location_id: String,
    val location_name: String?,
    val latitude: Double?,
    val longitude: Double?
)