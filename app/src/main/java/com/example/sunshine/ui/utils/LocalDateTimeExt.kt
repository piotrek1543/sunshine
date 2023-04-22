package com.example.sunshine.ui.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val LocalDateTime.formattedTime: String
    get() = this.format(DateTimeFormatter.ofPattern("HH:mm"))

val LocalDate.formattedDay: String
    get() = this.format(DateTimeFormatter.ofPattern("EEEE"))

val LocalDateTime.isNight: Boolean
    get() = hour !in DEFAULT_MORNING_HOUR..DEFAULT_EVENING_HOUR

private const val DEFAULT_MORNING_HOUR = 6
private const val DEFAULT_EVENING_HOUR = 22