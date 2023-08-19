package com.jimmy.core_network.data.remote.base.exception

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseError(
    @SerializedName("status_code")
    val code: Int = -1,
    @SerializedName("status_message")
    val message: String,
    val success: Boolean
)
