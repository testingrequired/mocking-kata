package com.testingrequired.mockingkata.services

import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class FizzBuzzService {
    fun fizzBuzz(number: BigInteger): String {
        return when (BigInteger.ZERO) {
            number % BigInteger.valueOf(15) -> "FizzBuzz"
            number % BigInteger.valueOf(3) -> "Fizz"
            number % BigInteger.valueOf(5) -> "Buzz"
            else -> number.toString()
        }
    }
}