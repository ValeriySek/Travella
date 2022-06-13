package com.app.travella

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}