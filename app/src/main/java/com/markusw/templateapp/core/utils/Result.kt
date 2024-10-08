package com.markusw.templateapp.core.utils

sealed class Result<T>(val data: T? = null, var message: String? = null) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(message: String) : Result<T>(null, message)
}