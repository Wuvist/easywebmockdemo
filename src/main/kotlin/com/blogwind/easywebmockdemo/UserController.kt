package com.blogwind.easywebmockdemo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }
}
