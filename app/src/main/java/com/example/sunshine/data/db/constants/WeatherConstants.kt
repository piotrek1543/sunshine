package com.example.sunshine.data.db.constants

/**
 * Defines constants for the Weather Table
 */
object WeatherConstants {

    const val TABLE_NAME = "weather"

    const val QUERY_WEATHER = "SELECT * FROM $TABLE_NAME"

    const val DELETE_ALL_WEATHERS = "DELETE FROM $TABLE_NAME"

}