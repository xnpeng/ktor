package com.ktor

import com.ktor.handler.handler
import freemarker.cache.ClassTemplateLoader
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.ConditionalHeaders
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.features.PartialContentSupport
import org.jetbrains.ktor.freemarker.FreeMarker
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.routing.Routing

class KtorApp : AutoCloseable {


    fun Application.install() {
        install(DefaultHeaders)
        install(CallLogging)
        install(ConditionalHeaders)
        install(PartialContentSupport)
        install(Locations)
        install(FreeMarker) {
            templateLoader = ClassTemplateLoader(KtorApp::class.java.classLoader, "templates")
        }

        install(Routing) {
            handler()
        }

        println("install completed.")
    }

    override fun close() {
    }

}
