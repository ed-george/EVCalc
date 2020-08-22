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

    @GetMapping("/calculate/mileage/{deviceType}")
    private fun calculateMileageView(
            @PathVariable deviceType: String,
            @RequestParam(value = "riderWeight") riderWeight: Int,
            @RequestParam(value = "airTemperature", required = false, defaultValue = "") airTemperature: Int,
            @RequestParam(value = "chargeCycles") chargeCycles: Int,
            @RequestParam(value = "currentPercentage", required = false, defaultValue = "100") currentPercentage: Int,
            @RequestParam(value = "batterySize") batterySize: Int,
            @RequestParam(value = "speedType") speedType: String
    ): Int {
        var result = 0
        if (deviceType == "euc") {
            result = CalculateMileage.calculateEUC(riderWeight, airTemperature, chargeCycles, batterySize, speedType)
        } else {

        }
        return result
    }

    @GetMapping("/calculate/batteryDrain/{deviceType}")
    private fun calculateBatteryDrainView(
            @PathVariable deviceType: String
    ) {

    }
}