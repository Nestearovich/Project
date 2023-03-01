package com.example.graduationproject.data

import com.google.gson.annotations.SerializedName


data class ApiResponseResults<T>(
    @SerializedName("status")
    val status: String?,
    @SerializedName("results")
    val results: List<T>,
) {

    fun getResultsOrThrow(): List<T> {
        if (status.equals("OK", true)) {
            return results
        } else {
            throw Exception("ApiResponse status $status")
        }
    }

}
