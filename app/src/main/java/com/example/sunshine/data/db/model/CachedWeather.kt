package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.WeatherConstants


/**
 * Model used solely for the caching of a [Weather]
 */
@Entity(
    tableName = WeatherConstants.TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = CachedMain::class,
        parentColumns = ["listDt"],
        childColumns = ["listDt"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CachedWeather(
    @PrimaryKey
    var listDt: Long? = null,
    var id: Int? = null,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null
)
