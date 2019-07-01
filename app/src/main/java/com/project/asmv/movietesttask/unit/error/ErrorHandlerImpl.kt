package com.project.asmv.movietesttask.unit.error

import android.content.Context
import com.project.asmv.movietesttask.R
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

//TODO Вот так примерно у нас делалось/ относительно просто и не гибко(как в вашем примере)
class ErrorHandlerImpl @Inject constructor(private val context: Context) : ErrorHandler {

    override fun getError(throwable: Throwable): String = when (throwable) {
        is UnknownHostException -> context.getString(R.string.unknown_host_exception)
        is HttpException ->
            when (throwable.code()) {
                401 -> context.getString(R.string.error_auth)
                in 500..599 -> context.getString(R.string.error_service_connection)
                else -> {
                    val responseBody: ResponseBody? = throwable.response().errorBody()
                    val error : String? = responseBody.toString()
                    error ?: context.getString(R.string.error_service_connection)
                }
            }
        else -> context.getString(R.string.unknown_exception)
    }



}