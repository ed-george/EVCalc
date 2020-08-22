package org.dynamium.etcalc.controller

import org.dynamium.etcalc.core.calculate.CalculateMileage
import org.dynamium.etcalc.dataclasses.DefaultResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
private class MainController {
    @GetMapping("/")
    private fun homePageView(): DefaultResponse {
        return DefaultResponse(
                text = "You have accessed the homepage of ETCalc service. To start working with ETCalc, please proceed to link specified here.",
                link = "https://example.com"
        )
    }

    @GetMapping("/calculate/mileage/euc")
    private fun calculateMileageEUCView(
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "airTemperature", required = false, defaultValue = "") airTemperature: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ): Int {
        return CalculateMileage.calculateEUC(riderWeight, airTemperature, chargeCycles, batterySize, currentPercentage, speedType)
    }

    @GetMapping("/calculate/mileage/es")
    private fun calculateMileageESView(
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "airTemperature", required = false, defaultValue = "") airTemperature: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ) {

    }

    @GetMapping("/calculate/batteryDrain/euc")
    private fun calculateBatteryDrainView() {

    }
}