package com.project.asmv.movietesttask.unit

import java.util.*

object Units {
    private const val ONE_MINUTE_IN_MILLIS: Long = 60000//millisecs
    private const val MINUTE_IN_TWO_HOURS: Long = 120

     fun createDateTo(time: Long): Date {
        return Date(time + MINUTE_IN_TWO_HOURS * ONE_MINUTE_IN_MILLIS)
    }
}