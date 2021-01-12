package com.testingrequired.mockingkata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = ["com.testingrequired"])
class MockingKataApplication(
        @Autowired private val app: App
) : CommandLineRunner {
    override fun run(vararg args: String?) {}
}

fun main(args: Array<String>) {
    runApplication<MockingKataApplication>(*args)
}
