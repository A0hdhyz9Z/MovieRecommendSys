package com.example.ex3_2_back

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

//@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@SpringBootApplication
class Ex32BackApplication

fun main(args: Array<String>) {
    runApplication<Ex32BackApplication>(*args)
}
