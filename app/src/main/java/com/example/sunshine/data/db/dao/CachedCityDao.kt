package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.CityConstants
import com.example.sunshine.data.db.model.CachedCity

@Dao
abstract class CachedCityDao {

    @Query(CityConstants.QUERY_CITY)
    abstract fun getCity(): CachedCity?

    @Query(CityConstants.DELETE_ALL_CITIES)
    abstract fun clearCity()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCity(cachedCity: CachedCity?)

}