package com.codependent.kafka.weather.stream

import java.util.*

data class DailyRain(val city: String, val date: Date, val mm: Double)
