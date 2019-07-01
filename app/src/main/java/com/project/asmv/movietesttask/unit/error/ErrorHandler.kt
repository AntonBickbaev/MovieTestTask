package com.project.asmv.movietesttask.unit.error

interface ErrorHandler {
    fun getError(throwable: Throwable): String
}