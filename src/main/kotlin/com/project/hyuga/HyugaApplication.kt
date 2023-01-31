package com.project.hyuga

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class HyugaApplication

fun main(args: Array<String>) {
    runApplication<HyugaApplication>(*args)
}
