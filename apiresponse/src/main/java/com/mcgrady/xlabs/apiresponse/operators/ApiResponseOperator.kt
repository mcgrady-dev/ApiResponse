package com.mcgrady.xlabs.apiresponse.operators

import com.mcgrady.xlabs.apiresponse.ApiResponse


/**
 * ApiResponseOperator operates on an [ApiResponse] and return an [ApiResponse].
 * This allows you to handle success and error response instead of the [onSuccess],
 * [onError], [onException] transformers.
 * This operator can be applied globally as a singleton instance, or on each [ApiResponse] one by one.
 */
abstract class ApiResponseOperator<T> : IResponseOperator {

  /**
   * Operates the [ApiResponse.Success] for handling successful responses if the request succeeds.
   *
   * @param apiResponse The successful response.
   */
  abstract fun onSuccess(apiResponse: ApiResponse.Success<T>)

  /**
   * Operates the [ApiResponse.Failure.Error] for handling error responses if the request failed.
   *
   * @param apiResponse The failed response.
   */
  abstract fun onError(apiResponse: ApiResponse.Failure.Error<T>)

  /**
   * Operates the [ApiResponse.Failure.Exception] for handling exception responses if the request get an exception.
   *
   * @param apiResponse The exception response.
   */
  abstract fun onException(apiResponse: ApiResponse.Failure.Exception<T>)
}
