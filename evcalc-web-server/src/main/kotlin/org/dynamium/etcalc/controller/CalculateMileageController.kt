package org.dynamium.etcalc.controller

import org.dynamium.etcalc.core.calculate.CalculateMileage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculateMileageController {

    val logger: Logger = LoggerFactory.getLogger(CalculateMileageController::class.java)

    @GetMapping("/mileage/euc")
    private fun calculateMileageEUCView(
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ): Int {
        val result = CalculateMileage.calculateEUC(riderWeight, chargeCycles, batterySize, currentPercentage, speedType)
        logger.debug("Called /mileage/euc endpoint with arguments riderWeight: $riderWeight, " +
                "chargeCycles: $chargeCycles, currentPercentage: $currentPercentage, batterySize: $batterySize, speedTYpe: $speedType. " +
                "Returned value: $result")
        return result
    }

    @GetMapping("/mileage/es")
    private fun calculateMileageESView(
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ) {

    }
}