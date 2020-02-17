package com.blogwind.easywebmockdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class UserController(val userService: UserService) {
    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }

    @GetMapping("/user/{userId}")
    fun user(@PathVariable userId: String): Mono<String> {
        val user = userService.getUser(userId)

        return user.map {
            "<html><body><h1>${it!!.name}: ${it!!.age}</body>"
        }
    }
}
