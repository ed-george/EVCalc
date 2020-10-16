package org.dynamium.etcalc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculateBatteryDrainController {

    @GetMapping("/batteryDrain/euc")
    private fun calculateBatteryDrainEUCView() {

    }

    @GetMapping("/batteryDrain/es")
    private fun calculateBatteryDrainESView() {

    }
}