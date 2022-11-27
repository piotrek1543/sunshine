package com.example.sunshine.data.db.constants

/**
 * Defines constants for the Pod Table
 */
object PodConstants {

    const val TABLE_NAME = "pod"

    const val QUERY_POD = "SELECT * FROM $TABLE_NAME"

    const val DELETE_ALL_PODS = "DELETE FROM $TABLE_NAME"

}