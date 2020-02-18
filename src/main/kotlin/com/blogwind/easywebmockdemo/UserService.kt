package com.blogwind.easywebmockdemo

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Service
class UserService(properties: DemoProperties) {
    private val client = WebClient.create(properties.backendUrl)

    fun getUser(userId: String): Mono<User?> {
        return client.get()
                .uri { it.path("/user.json")
                    .queryParam("id", userId)
                    .build() }
                .retrieve()
                .onStatus({ status -> !status.is2xxSuccessful }) { resp ->
                    val status = resp.statusCode()
                    resp.bodyToMono(String::class.java)
                        .map { ResponseStatusException(status, it) }
                }
                .bodyToMono(User::class.java)
                .map { it ->
                    it.email = ""
                    it
                }
    }
}