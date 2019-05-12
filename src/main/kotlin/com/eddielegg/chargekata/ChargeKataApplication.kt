package com.eddielegg.chargekata

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@PropertySources(
        PropertySource("classpath:application.properties"),
        PropertySource(value = "classpath:application.properties.local", ignoreResourceNotFound = true)
)
class ChargeKataApplication {
    /**
     * Rest Template bean
     */
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<ChargeKataApplication>(*args)
}