package com.mcgrady.xlabs.apiresponse

/**
 * Returns true if this instance represents an [ApiResponse.Success].
 */
inline val ApiResponse<Any>.isSuccess: Boolean
    get() = this is ApiResponse.Success

/**
 * Returns true if this instance represents an [ApiResponse.Failure].
 */
inline val ApiResponse<Any>.isFailure: Boolean
    get() = this is ApiResponse.Failure

/**
 * Returns true if this instance represents an [ApiResponse.Failure.Error].
 */
inline val ApiResponse<Any>.isError: Boolean
    get() = this is ApiResponse.Failure.Error

/**
 * Returns true if this instance represents an [ApiResponse.Failure.Exception].
 */
inline val ApiResponse<Any>.isException: Boolean
    get() = this is ApiResponse.Failure.Exception

/**
 * Returns The error message or null depending on the type of [ApiResponse].
 */
inline val ApiResponse<Any>.messageOrNull: String?
    get() = when (this) {
        is ApiResponse.Failure.Error -> message()
        is ApiResponse.Failure.Exception -> message
        else -> null
    }