package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.CityConstants

/**
 * Model used solely for the caching of a [City]
 */
@Entity(tableName = CityConstants.TABLE_NAME)
data class CachedCity(
    @PrimaryKey
    var id: Int = 1000,
    var name: String? = null,
    // var cachedCoord: CachedCoord? = null,
    var country: String? = null,
    var population: Int? = null
)
