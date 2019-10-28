package com.orcchg.domain.exception

class SafeSerializableException(causeClass: String, message: String) : RuntimeException("[$causeClass]: $message")
