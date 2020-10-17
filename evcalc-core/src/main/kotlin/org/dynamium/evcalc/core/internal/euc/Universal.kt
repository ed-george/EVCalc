package org.dynamium.evcalc.core.internal.euc

import java.lang.IllegalArgumentException

/*
 * EVCalc Universal Calculation
 *
 * This code calculates values that are universal for any unicycle.
 * For any documentation about inner workings of the universal calculation visit Wiki on GitHub.
 */

// Start constants
private const val startRiderWeight = 75
private const val startBatteryCapacity = 1554
private const val startAirTemperatureStart = 20
private const val startAirTemperatureEnd = 30
private const val startBatteryCycles = 100
private const val startSpeed = 35
private const val startMileage = 88

// Multipliers
private const val riderWeightOffsetMultiplier = 2
private const val batteryCapacityOffsetMultiplier = 15
private const val airTempOffsetMultiplier = 1
private const val batteryCyclesOffsetSubtractor = 2

internal object Universal {
    fun calculateMileage(riderWeight: Int, batteryCapacity: Int, airTemp: Int, batteryCycles: Int, speed: Int): Int {
        val riderWeightOffset = calculateOffsets("riderWeight", riderWeight)
        val batteryCapacityOffset = calculateOffsets("batteryCapacity", batteryCapacity)
        val airTempOffset = calculateOffsets("airTemp", airTemp)
        return 1
    }

    private fun calculateOffsets(name: String, value: Int): Int {
        var calculatedValue: Int = 0
        when (name) {
            "riderWeight" -> {
                calculatedValue = when {
                    value < startRiderWeight -> {
                        val offset = value - startRiderWeight // Get the offset by subtracting
                        offset * startRiderWeight // Apply our data to returned value
                    }
                    value > startRiderWeight -> {
                        val offset = value - startAirTemperatureEnd // Get the offset by subtracting
                        offset * airTempOffsetMultiplier // Apply our data to returned value
                    }
                    else -> {
                        value
                    }
                }
            }
            "batteryCapacity" -> {

            }
            "airTemp" -> {
                calculatedValue = when {
                    value < startAirTemperatureStart -> {
                        val offset = value - startAirTemperatureStart // Get the offset by subtracting
                        offset * airTempOffsetMultiplier // Apply our data to returned value
                    }
                    value > startAirTemperatureEnd -> {
                        val offset = value - startAirTemperatureEnd // Get the offset by subtracting
                        offset * airTempOffsetMultiplier // Apply our data to returned value
                    }
                    else -> {
                        value
                    }
                }
            }
            "batteryCycles" -> {

            }
            "speed" -> {

            }
            else -> { // If the name is unknown, throw an exception
                throw IllegalArgumentException(
                    "Internal EVCalc Core exception: unknown name specified for calculating offsets." +
                            "Contact support to report this error, or go to https://github.com/Dynamium/EVCalc/issues to report this bug. " +
                            "Please specify everything you done which triggered this exception."
                )
            }
        }
        return calculatedValue
    }
}