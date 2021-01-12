package com.testingrequired.fibonacciservice

import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class FibonacciSequenceService {
    fun fibonacciSequence(firstNumber: BigInteger, maxItems: Int = 2): Sequence<BigInteger> {
        return sequence {
            var previous = Pair(BigInteger.ZERO, firstNumber)
            while (true) {
                yield(previous.second)
                previous = Pair(previous.second, previous.first + previous.second)
            }
        }.take(maxItems)
    }
}