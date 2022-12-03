package com.example.sunshine.data.cache

import androidx.room.TypeConverter
import java.time.LocalDateTime

object Converters {

    @TypeConverter
    fun toDateTime(dateTimeString: String?): LocalDateTime? = when (dateTimeString) {
        null -> null
        else -> LocalDateTime.parse(dateTimeString)
    }

    @TypeConverter
    fun toDateTimeString(dateTime: LocalDateTime?): String? = dateTime?.toString()
}
