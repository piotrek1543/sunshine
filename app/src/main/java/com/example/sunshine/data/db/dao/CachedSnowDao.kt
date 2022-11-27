package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.SnowConstants
import com.example.sunshine.data.db.model.CachedSnow

@Dao
abstract class CachedSnowDao {

    @Query(SnowConstants.QUERY_SNOW)
    abstract fun getSnow(): List<CachedSnow>?

    @Query(SnowConstants.DELETE_ALL_SNOWS)
    abstract fun clearSnow()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSnow(cachedSnow: List<CachedSnow>?)

}