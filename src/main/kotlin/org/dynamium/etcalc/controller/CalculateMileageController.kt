package org.dynamium.etcalc.controller

import org.dynamium.etcalc.core.calculate.CalculateMileage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculateMileageController {

    @GetMapping("/mileage/euc")
    private fun calculateMileageEUCView(
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ): Int {
        return CalculateMileage.calculateEUC(riderWeight, chargeCycles, batterySize, currentPercentage, speedType)
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