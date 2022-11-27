package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.CloudsConstants
import com.example.sunshine.data.db.model.CachedClouds

@Dao
interface CachedCloudsDao {

    @Query(CloudsConstants.QUERY_CLOUDS)
    suspend fun getClouds(): List<CachedClouds>?

    @Query(CloudsConstants.DELETE_ALL_CLOUDS)
    suspend fun clearClouds()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClouds(cachedClouds: List<CachedClouds>?)

}
