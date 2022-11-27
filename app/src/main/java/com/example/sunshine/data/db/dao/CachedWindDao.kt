package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.WindConstants
import com.example.sunshine.data.db.model.CachedWind

@Dao
abstract class CachedWindDao {

    @Query(WindConstants.QUERY_WIND)
    abstract fun getWind(): List<CachedWind>?

    @Query(WindConstants.DELETE_ALL_WINDS)
    abstract fun clearWind()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWind(cachedWind: List<CachedWind>?)

}