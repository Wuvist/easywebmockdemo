package com.blogwind.easywebmockdemo

import com.blogwind.easywebmock.MockServerManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
    classes = [DemoApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration(initializers = [ConfigInitializer::class])
class DemoApplicationTests {
    @Autowired
    private lateinit var properties: DemoProperties

    @Test
    fun contextLoads() {
        Assertions.assertEquals(properties.backendUrl, MockServerManager.getUrl())
    }
}

class ConfigInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    override fun initialize(context: ConfigurableApplicationContext) {
        TestPropertyValues.of("demo.backendUrl: " + MockServerManager.getUrl())
            .applyTo(context.environment)
    }
}