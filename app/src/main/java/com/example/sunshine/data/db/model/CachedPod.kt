package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.PodConstants

/**
 * Model used solely for the caching of a [Pod]
 */
@Entity(tableName = PodConstants.TABLE_NAME,
        foreignKeys = [ForeignKey(entity = CachedWind::class,
                parentColumns = ["listDt"],
                childColumns = ["listDt"],
                onDelete = ForeignKey.CASCADE)]
)
data class CachedPod(
        @PrimaryKey
        var listDt: Long? = null,
        var id: Int = 0,
        var pod: String? = null
)
