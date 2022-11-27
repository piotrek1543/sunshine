package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.MainConstants
import com.example.sunshine.data.db.model.CachedMain

@Dao
abstract class CachedMainDao {

    @Query(MainConstants.QUERY_MAIN)
    abstract fun getMain(): List<CachedMain>?

    @Query(MainConstants.DELETE_ALL_MAINS)
    abstract fun clearMain()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMain(cachedMain: List<CachedMain>?)

}