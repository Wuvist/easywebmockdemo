package com.blogwind.easywebmockdemo

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ResponseStatusException

class UserService(properties: DemoProperties) {
    private val client = WebClient.create(properties.backendUrl)

    fun getUser(userId: String): User? {
        val user = client.get()
            .uri { it.path("/user?id=$userId").build() }
            .retrieve()
            .onStatus({ status -> !status.is2xxSuccessful }) {
                val status = it.statusCode()
                it.bodyToMono(String::class.java)
                    .map { ResponseStatusException(status, it) }
            }
            .bodyToMono(User::class.java).block()

        if (user == null) {
            return null
        }

        user.email = ""

        return user
    }

}