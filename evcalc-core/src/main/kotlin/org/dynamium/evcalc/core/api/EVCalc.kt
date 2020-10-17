@file:Suppress("unused")

package org.dynamium.evcalc.core.api

import org.dynamium.evcalc.core.internal.euc.Universal


/*
 * EVCalc Calculation Engine
 *
 * This is the main API File. For more info visit Wiki on GitHub.
 */
object EVCalc {
    /*object ES {
        fun calculateMileage(riderWeight: Int, batteryCapacity: Int, airTemp: Int, batteryCycles: Int, speed: Int) {

        }
    }*/
    object EUC {
        fun calculateMileage(
            riderWeight: Int,
            batteryCapacity: Int,
            airTemp: Int = 28,
            batteryCycles: Int = 100,
            speed: Int,
            device: String = "Universal"
        ): Int {
            val calculatedValue: Int
            when (device) {
                "Universal" -> {
                    calculatedValue =
                        Universal.calculateMileage(riderWeight, batteryCapacity, airTemp, batteryCycles, speed)
                }
                else -> {
                    throw IllegalArgumentException(
                        "EVCalc API Exception: unknown argument specified. " +
                                "If this behaviour is unexpected, please report this exception on " +
                                "GitHub Issues https://github.com/Dynamium/EVCalc/issues with all needed data."
                    )
                }
            }
            return calculatedValue
        }
    }
}