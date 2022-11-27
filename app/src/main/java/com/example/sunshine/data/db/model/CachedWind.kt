package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.WindConstants

/**
 * Model used solely for the caching of a [Wind]
 */
@Entity(tableName = WindConstants.TABLE_NAME,
        foreignKeys = [ForeignKey(entity = CachedClouds::class,
                parentColumns = ["listDt"],
                childColumns = ["listDt"],
                onDelete = ForeignKey.CASCADE)]
)
data class CachedWind(
        @PrimaryKey
        var listDt: Long? = null,
        var speed: Double? = null,
        var deg: Float? = null
)