package com.testingrequired.mockingkata.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import java.math.BigInteger

@ExtendWith(SpringExtension::class)
@SpringJUnitConfig(classes = [FizzBuzzService::class])
internal class FizzBuzzServiceTest {
    @Autowired
    private lateinit var fizzBuzzService: FizzBuzzService

    @Test
    fun `should map multiples of 3 to fizz`() {
        assertEquals("Fizz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(3)))
        assertEquals("Fizz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(3 * 2)))
        assertEquals("Fizz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(3 * 3)))
    }

    @Test
    fun `should map multiples of 5 to buzz`() {
        assertEquals("Buzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(5)))
        assertEquals("Buzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(5 * 2)))
        assertEquals("Buzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(5 * 4)))
    }

    @Test
    fun `should map 15 to fizzbuzz`() {
        assertEquals("FizzBuzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(15)))
        assertEquals("FizzBuzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(15 * 2)))
        assertEquals("FizzBuzz", fizzBuzzService.fizzBuzz(BigInteger.valueOf(15 * 3)))
    }

    @Test
    fun `should map non-multiples of 3 and 5 to itself`() {
        assertEquals("1", fizzBuzzService.fizzBuzz(BigInteger.valueOf(1)))
        assertEquals("2", fizzBuzzService.fizzBuzz(BigInteger.valueOf(2)))
        assertEquals("4", fizzBuzzService.fizzBuzz(BigInteger.valueOf(4)))
    }
}