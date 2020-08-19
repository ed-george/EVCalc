package org.dynamium.etcalc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EtCalcApplication

fun main(args: Array<String>) {
    runApplication<EtCalcApplication>(*args)
}
