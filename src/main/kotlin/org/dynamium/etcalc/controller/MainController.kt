package org.dynamium.etcalc.controller

import org.dynamium.etcalc.dataclasses.DefaultResponse
import org.springframework.web.bind.annotation.GetMapping
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
}