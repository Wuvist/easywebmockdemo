package com.blogwind.easywebmockdemo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@RunWith(JUnitPlatform::class)
@SpringBootTest
@ContextConfiguration(initializers = [ConfigInitializer::class], classes = [DemoApplication::class])
class WebMockControllerTest {
    @Test
    fun testController() {
        assertEquals("","")
    }
}