package com.blogwind.easywebmockdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {
    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }

    @GetMapping("/user/{userId}")
    fun user(@PathVariable userId: String): String {
        val user = userService.getUser(userId) ?: return "Not Found"

        return "<html><body><h1>${user.name}: ${user.age}</body>"
    }
}
