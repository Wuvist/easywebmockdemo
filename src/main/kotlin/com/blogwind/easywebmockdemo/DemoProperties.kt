package com.blogwind.easywebmockdemo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("demo")
data class DemoProperties(val backendUrl: String)