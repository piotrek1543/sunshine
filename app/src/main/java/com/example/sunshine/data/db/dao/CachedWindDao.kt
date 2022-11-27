package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.WindConstants
import com.example.sunshine.data.db.model.CachedWind

@Dao
interface CachedWindDao {

    @Query(WindConstants.QUERY_WIND)
    suspend fun getWind(): List<CachedWind>?

    @Query(WindConstants.DELETE_ALL_WINDS)
    suspend fun clearWind()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWind(cachedWind: List<CachedWind>?)
}
