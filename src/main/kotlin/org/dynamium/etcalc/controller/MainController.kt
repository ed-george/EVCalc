package org.dynamium.etcalc.controller

import org.dynamium.etcalc.core.CalculateMileage
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
            @RequestParam("riderWeight") riderWeight: Int,
            @RequestParam("airTemperature") airTemperature: Int,
            @RequestParam("chargeCycles") chargeCycles: Int,
            @RequestParam("batterySize") batterySize: Int,
            @RequestParam("speedType") speedType: String
    ): Int {
        var result = 0
        if (deviceType == "euc") {
            result = CalculateMileage.calculateEUC(riderWeight, airTemperature, chargeCycles, batterySize, speedType)
        }
        return result
    }

    @GetMapping("/calculate/batteryDrain/{device}")
    private fun calculateBatteryDrainView(@PathVariable device: String) {

    }
}