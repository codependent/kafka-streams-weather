package com.codependent.kafka.weather.configuration

import com.codependent.kafka.weather.stream.DailyRain
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import java.util.function.Supplier

/**
 * @author José A. Íñigo
 */
@Configuration
class KafkaProducerConfiguration {

    @Bean
    fun dailyRainEmmiterProcessor(): EmitterProcessor<Message<DailyRain>> {
        return EmitterProcessor.create<Message<DailyRain>>()
    }

    @Bean
    fun dailyRain(): Supplier<Flux<Message<DailyRain>>> {
        return Supplier { dailyRainEmmiterProcessor() }
    }

}
