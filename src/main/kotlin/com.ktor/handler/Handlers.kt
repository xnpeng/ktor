package com.ktor.handler

import com.ktor.model.User
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.content.default
import org.jetbrains.ktor.content.files
import org.jetbrains.ktor.content.static
import org.jetbrains.ktor.content.staticRootFolder
import org.jetbrains.ktor.freemarker.FreeMarkerContent
import org.jetbrains.ktor.locations.get
import org.jetbrains.ktor.locations.location
import org.jetbrains.ktor.locations.post
import org.jetbrains.ktor.routing.Route
import java.io.File

@location("/") class Index

@location("/login") data class Login(val userId: String = "", val password: String = "")

@location("/mylogin") data class MyLogin(val userId: String = "", val password: String = "")

fun Route.handler() {

    static {
        staticRootFolder = File("public")
        files(".")
        //default("index.html")
    }

    get<Index> {
        call.respond(FreeMarkerContent("index.ftl", mapOf("userId" to "username", "password" to "password"), ""))
    }

    get<Login> {
        call.respond(FreeMarkerContent("login.ftl", emptyMap<String, Any>(), ""))
    }

    post<Login> {
        if (it.userId == "username" && it.password == "password") {
            val user = User(userId = it.userId, email = "user@email.com", password = it.password)
            call.respond(FreeMarkerContent("index.ftl", mapOf("user" to user, "error" to null), ""))
        } else {
            call.respond(FreeMarkerContent("index.ftl", mapOf("error" to "login failed", "user" to null), ""))
        }
    }

    get<MyLogin>{
        call.respond(FreeMarkerContent("login.ftl", emptyMap<String, Any>(), ""))
    }
}