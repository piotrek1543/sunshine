package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.SnowConstants
import com.example.sunshine.data.db.model.CachedSnow

@Dao
interface CachedSnowDao {

    @Query(SnowConstants.QUERY_SNOW)
    suspend fun getSnow(): List<CachedSnow>?

    @Query(SnowConstants.DELETE_ALL_SNOWS)
    suspend fun clearSnow()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSnow(cachedSnow: List<CachedSnow>?)
}
