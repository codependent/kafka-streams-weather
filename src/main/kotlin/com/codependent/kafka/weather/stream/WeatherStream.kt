package com.codependent.kafka.weather.stream

import org.apache.kafka.streams.kstream.KStream
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer


@Configuration
class WeatherStream {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun process(): Consumer<KStream<String, DailyRain>> {
        return Consumer { dailyRain ->
            dailyRain.foreach { key, value ->
                println("$key $value")
            }
        }
    }

}
