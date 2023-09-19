package com.mcgrady.xlabs.apiresponse.adapters

import com.mcgrady.xlabs.apiresponse.ApiResponse
import com.mcgrady.xlabs.apiresponse.ApiResponseInitializer
import com.mcgrady.xlabs.apiresponse.adapters.internal.ApiResponseCallAdapter
import com.mcgrady.xlabs.apiresponse.adapters.internal.ApiResponseDeferredCallAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * CoroutinesResponseCallAdapterFactory is an coroutines call adapter factory for creating [ApiResponse].
 * Adding this class to [Retrofit] allows you to return on [ApiResponse] from service method.
 */
class ApiResponseCallAdapterFactory private constructor(
    private val coroutineScope: CoroutineScope,
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        when (getRawType(returnType)) {
            Call::class.java -> {
                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
                val rawType = getRawType(callType)
                if (rawType != ApiResponse::class.java) {
                    return null
                }

                val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                return ApiResponseCallAdapter(resultType, coroutineScope)
            }

            Deferred::class.java -> {
                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
                val rawType = getRawType(callType)
                if (rawType != ApiResponse::class.java) {
                    return null
                }

                val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                return ApiResponseDeferredCallAdapter<Any>(resultType, coroutineScope)
            }

            else -> return null
        }
    }

    companion object {
        @JvmStatic
        fun create(coroutineScope: CoroutineScope = ApiResponseInitializer.coroutineScope): ApiResponseCallAdapterFactory =
            ApiResponseCallAdapterFactory(coroutineScope)
    }
}
