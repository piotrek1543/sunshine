package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.CloudsConstants

/**
 * Model used solely for the caching of a [Clouds]
 */
@Entity(
    tableName = CloudsConstants.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CachedWeather::class,
            parentColumns = ["listDt"],
            childColumns = ["listDt"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CachedClouds(
    @PrimaryKey
    var listDt: Long? = null,
    var all: Int? = null
)
