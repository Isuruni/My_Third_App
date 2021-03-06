package com.uni.kelani.mythirdapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.uni.kelani.mythirdapp.model.Locations

@Dao
interface LocationsDao {
    @Query("SELECT * FROM locations")
    fun getAll(): List<Locations>

    @Query("SELECT * FROM locations WHERE location_id IN (:location_id)")
    fun getById(location_id: String): Locations

   // @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    //fun loadAllByIds(userIds: IntArray): List<User>

    //@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            //"last_name LIKE :last LIMIT 1")
    //fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg locations: Locations)

    @Delete
    fun delete(locations: Locations)
}