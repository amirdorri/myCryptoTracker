package com.plcoding.amirdorri.core.data.networking

import android.util.Log
import com.plcoding.amirdorri.core.domain.util.NetworkError
import com.plcoding.amirdorri.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(response : HttpResponse) : Result <T , NetworkError> {
    Log.e("dorrri3", response.status.value.toString())
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Log.e("dorrri4", response.status.value.toString())
            Result.Success(response.body<T>())
            } catch (e : NoTransformationFoundException){

                Result.Error(NetworkError.SERIALIZATION)
            }
        }
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)

        429 -> Result.Error(NetworkError.TOO_MANY_REQUEST)

        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)

        else -> Result.Error(NetworkError.UNKNOWN)

    }

}