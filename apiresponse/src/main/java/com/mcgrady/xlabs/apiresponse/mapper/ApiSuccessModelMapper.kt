package com.mcgrady.xlabs.apiresponse.mapper

import com.mcgrady.xlabs.apiresponse.ApiResponse

/**
 * A mapper interface for mapping [ApiResponse.Success] response as a custom [V] instance model.
 */
fun interface ApiSuccessModelMapper<T, V> {

    /**
     * maps the [ApiResponse.Success] to the [V] using the mapper.
     *
     * @param apiSuccessResponse The [ApiResponse.Success] response from the network request.
     * @return A custom [V] success response model.
     */
    fun map(apiSuccessResponse: ApiResponse.Success<T>): V
}