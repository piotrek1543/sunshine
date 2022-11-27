package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.CoordConstants
import com.example.sunshine.data.db.model.CachedCoord

@Dao
abstract class CachedCoordDao {

    @Query(CoordConstants.QUERY_COORD)
    abstract fun getCoord(): CachedCoord?

    @Query(CoordConstants.DELETE_ALL_COORDS)
    abstract fun clearCoord()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCoord(cachedCoord: CachedCoord?)

}