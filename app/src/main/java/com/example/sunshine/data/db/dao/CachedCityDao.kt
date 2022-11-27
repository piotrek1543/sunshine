package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.CityConstants
import com.example.sunshine.data.db.model.CachedCity

@Dao
interface CachedCityDao {

    @Query(CityConstants.QUERY_CITY)
    suspend fun getCity(): CachedCity?

    @Query(CityConstants.DELETE_ALL_CITIES)
    suspend fun clearCity()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cachedCity: CachedCity?)
}
