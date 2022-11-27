package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.RainConstants

/**
 * Model used solely for the caching of a [Rain]
 */
@Entity(tableName = RainConstants.TABLE_NAME,
        foreignKeys = [ForeignKey(entity = CachedWind::class,
                parentColumns = ["listDt"],
                childColumns = ["listDt"],
                onDelete = ForeignKey.CASCADE)])
data class CachedRain(
        @PrimaryKey(autoGenerate = true)
        var listDt: Long? = null,
        var in3h: Double? = null
)
