package com.codependent.kafka.weather.web

import com.codependent.kafka.weather.stream.DailyRain
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.EmitterProcessor

@RestController
class WeatherController(private val dailyRainEmmiterProcessor: EmitterProcessor<Message<DailyRain>>) {

    @PostMapping("/wheater")
    fun postWheather(@RequestBody dailyRain: DailyRain) {
        val message = MessageBuilder.withPayload(dailyRain)
                .setHeader(KafkaHeaders.MESSAGE_KEY, dailyRain.city)
                .setHeader(KafkaHeaders.TIMESTAMP, dailyRain.date)
                .build()
        dailyRainEmmiterProcessor.onNext(message)
    }

}
