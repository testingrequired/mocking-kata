package com.testingrequired.fibonacciservice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import java.math.BigInteger
import kotlin.random.Random

@ExtendWith(SpringExtension::class)
@SpringJUnitConfig(classes = [FibonacciSequenceService::class])
internal class FibonacciSequenceServiceTest {
    private val startValue = BigInteger.valueOf(Random.nextLong())
    private val expectedMaxItems = 5

    @Autowired
    private lateinit var fibonacciSequenceService: FibonacciSequenceService

    @Test
    fun `should return a max number of items`() {
        val seq = fibonacciSequenceService.fibonacciSequence(startValue, expectedMaxItems)

        assertEquals(expectedMaxItems, seq.toList().size)
    }

    @Test
    fun `should return a default max number of items if not set`() {
        val seq = fibonacciSequenceService.fibonacciSequence(startValue)

        assertEquals(2, seq.toList().size)
    }

    @Test
    fun `should return values in golden ratio`() {
        val seq = fibonacciSequenceService.fibonacciSequence(startValue, expectedMaxItems)
        val list = seq.toList()

        assertEquals(startValue, list[0])
        assertEquals(list[0], list[1])
        assertEquals(list[0] + list[1], list[2])
        assertEquals(list[1] + list[2], list[3])
        assertEquals(list[2] + list[3], list[4])
    }

    @Test
    fun `should return values in golden ratio if max items not set`() {
        val seq = fibonacciSequenceService.fibonacciSequence(startValue)
        val list = seq.toList()

        assertEquals(startValue, list[0])
        assertEquals(list[0], list[1])
    }
}