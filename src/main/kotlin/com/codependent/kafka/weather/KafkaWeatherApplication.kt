package com.codependent.kafka.weather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaWeatherApplication

fun main(args: Array<String>) {
	runApplication<KafkaWeatherApplication>(*args)
}
