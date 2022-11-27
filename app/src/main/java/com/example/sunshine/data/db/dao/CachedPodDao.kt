package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.PodConstants
import com.example.sunshine.data.db.model.CachedPod

@Dao
interface CachedPodDao {

    @Query(PodConstants.QUERY_POD)
    suspend fun getPod(): List<CachedPod>?

    @Query(PodConstants.DELETE_ALL_PODS)
    suspend fun clearPod()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPod(cachedPod: List<CachedPod>?)
}
