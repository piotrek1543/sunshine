package com.example.sunshine.ui.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val LocalDateTime.formattedTime: String
    get() = this.format(DateTimeFormatter.ofPattern("HH:mm"))

val LocalDate.formattedDay: String
    get() = this.format(DateTimeFormatter.ofPattern("EEEE"))
