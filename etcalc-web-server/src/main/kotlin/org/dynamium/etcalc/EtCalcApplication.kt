package org.dynamium.etcalc

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EtCalcApplication

fun main(args: Array<String>) {
    val logger: Logger = LoggerFactory.getLogger(EtCalcApplication::class.java)
    runApplication<EtCalcApplication>(*args)
    logger.info("ETCalc application has successfully started!")
}
