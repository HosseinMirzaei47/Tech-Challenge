package com.example.app.shared.exceptions

class ServerException(message: String?, val code: Int?) : Exception(message)
