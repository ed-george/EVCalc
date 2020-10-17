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
private const val startBatteryCapacity = 1555
private const val startAirTemperatureStart = 20
private const val startAirTemperatureEnd = 30
private const val startBatteryCycles = 100
private const val startSpeed = 35
private const val startMileage = 88

// Multipliers
private const val riderWeightOffset = 2
private const val batteryCapacityOffset = 15
private const val airTempOffset = 1
private const val batteryCyclesOffset = 2

internal object Universal {
    fun calculateMileage(riderWeight: Int, batteryCapacity: Int, airTemp: Int, batteryCycles: Int, speed: Int): Int {
        var calculatedValue = startMileage

        // Apply weight offset
        if (riderWeight < startRiderWeight) { // If weight is less that initial value
            calculatedValue += calculateOffset("riderWeight", riderWeight) // Add offset to end value
        } else if (riderWeight > startRiderWeight) { //
            calculatedValue -= calculateOffset("riderWeight", riderWeight)
        }

        // Apply battery capacity offset
        if (batteryCapacity < startBatteryCapacity) { // Applying battery capacity offset
            calculatedValue -= calculateOffset("batteryCapacity", batteryCapacity)
        } else if (batteryCapacity > startBatteryCapacity) {
            calculatedValue += calculateOffset("batteryCapacity", batteryCapacity)
        }

        calculatedValue -= calculateOffset("airTemp", airTemp) // Apply air temperature offset

        return calculatedValue
    }

    private fun calculateOffset(name: String, rawValue: Int): Int {
        var calculatedValue: Int = 0
        when (name) {
            "riderWeight" -> {
                calculatedValue = when {
                    rawValue < startRiderWeight -> {
                        val offset = startRiderWeight - rawValue // Get the offset by subtracting
                        offset * startRiderWeight // Apply our data to returned value
                    }
                    rawValue > startRiderWeight -> {
                        val offset = rawValue - startAirTemperatureEnd // Get the offset by subtracting
                        offset * airTempOffset // Apply our data to returned value
                    }
                    else -> {
                        rawValue
                    }
                }
            }
            "batteryCapacity" -> {
                calculatedValue = rawValue / batteryCapacityOffset
            }
            "airTemp" -> {
                calculatedValue = when {
                    rawValue < startAirTemperatureStart -> {
                        val offset = startAirTemperatureStart - rawValue // Get the offset by subtracting
                        offset * airTempOffset // Apply our data to returned value
                    }
                    rawValue > startAirTemperatureEnd -> {
                        val offset = rawValue - startAirTemperatureEnd // Get the offset by subtracting
                        offset * airTempOffset // Apply our data to returned value
                    }
                    else -> {
                        rawValue
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