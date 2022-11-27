package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.PodConstants
import com.example.sunshine.data.db.model.CachedPod

@Dao
abstract class CachedPodDao {

    @Query(PodConstants.QUERY_POD)
    abstract fun getPod(): List<CachedPod>?

    @Query(PodConstants.DELETE_ALL_PODS)
    abstract fun clearPod()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPod(cachedPod: List<CachedPod>?)

}