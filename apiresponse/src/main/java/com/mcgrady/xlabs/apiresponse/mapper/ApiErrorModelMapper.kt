package com.mcgrady.xlabs.apiresponse.mapper

import com.mcgrady.xlabs.apiresponse.ApiResponse

fun interface ApiErrorModelMapper<V> {

    /**
     * maps the [ApiResponse.Failure.Error] to the [V] using the mapper.
     *
     * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
     * @return A custom [V] error response model.
     */
    fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): V
}