package com.testingrequired.mockingkata.services

import org.springframework.stereotype.Service
import java.util.Base64

@Service
class EncoderService {
    fun encode(value: String): String {
        return Base64.getEncoder().encodeToString(value.toByteArray())
    }
}