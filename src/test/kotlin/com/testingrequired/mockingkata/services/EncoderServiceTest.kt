package com.testingrequired.mockingkata.services

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import java.util.Base64

@ExtendWith(SpringExtension::class)
@SpringJUnitConfig(classes = [EncoderService::class])
internal class EncoderServiceTest {
    val expectedInputValue = "expectedInputValue"
    val expectedEncodedValue = "expectedEncodedValue"

    @MockkBean
    private lateinit var encoder: Base64.Encoder

    @Autowired
    private lateinit var encoderService: EncoderService

    @BeforeEach
    fun setup() {
        mockkStatic(Base64::class)
        every { Base64.getEncoder() } returns encoder
        every { encoder.encodeToString(expectedInputValue.toByteArray()) } returns expectedEncodedValue
    }

    @Test
    fun `should work`() {
        assertEquals(expectedEncodedValue, encoderService.encode(expectedInputValue))
    }
}