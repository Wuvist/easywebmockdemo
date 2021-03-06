package com.blogwind.easywebmockdemo

import com.blogwind.easywebmock.MockServerManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(initializers = [ConfigInitializer::class], classes = [DemoApplication::class])
class WebMockControllerTest {
    @Autowired
    lateinit var controller: UserController

    @Test
    fun testController() {
        val user = User("test user", "test@abc.com", 18)
        MockServerManager.setDefaultResponseJson("/user.json", user)

        val html = controller.user("userId").block()!!

        assertEquals(html, "<html><body><h1>test user: 18</body>")
    }
}