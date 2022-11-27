package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.CoordConstants
import com.example.sunshine.data.db.model.CachedCoord

@Dao
interface CachedCoordDao {

    @Query(CoordConstants.QUERY_COORD)
    suspend fun getCoord(): CachedCoord?

    @Query(CoordConstants.DELETE_ALL_COORDS)
    suspend fun clearCoord()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoord(cachedCoord: CachedCoord?)
}
