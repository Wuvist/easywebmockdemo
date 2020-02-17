package com.blogwind.easywebmockdemo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Mono

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
class MockitoControllerTest {
    @Mock
    lateinit var userService: UserService

    @InjectMocks
    lateinit var controller: UserController

    @Test
    fun testUserController() {
        val user = User("test user", "test@abc.com", 18)
        `when`(userService.getUser(anyString())).thenReturn(Mono.just(user));

        val html = controller.user("userId").block()!!

        assertEquals(html, "<html><body><h1>test user: 18</body>")
    }
}