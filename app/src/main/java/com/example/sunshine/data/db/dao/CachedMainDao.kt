package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.MainConstants
import com.example.sunshine.data.db.model.CachedMain

@Dao
interface CachedMainDao {

    @Query(MainConstants.QUERY_MAIN)
    suspend fun getMain(): List<CachedMain>?

    @Query(MainConstants.DELETE_ALL_MAINS)
    suspend fun clearMain()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(cachedMain: List<CachedMain>?)

}
