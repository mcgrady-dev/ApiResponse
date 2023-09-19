package com.mcgrady.xlabs.apiresponse


import com.mcgrady.xlabs.apiresponse.operators.IResponseOperator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okio.Timeout

object ApiResponseInitializer {

    @JvmStatic
    var successCodeRange: IntRange = 200..299

    @JvmStatic
    var responseOperators: MutableList<IResponseOperator> = mutableListOf()

    @JvmSynthetic
    var coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    @JvmStatic
    var timeout: Timeout? = null

    const val TAG = "ApiResponse"
}