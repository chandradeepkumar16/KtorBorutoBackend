package com.chandradeepdev.plugins

import com.chandradeepdev.di.koinModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger
import io.ktor.server.application.install as install


fun Application.configureKoin(){
    install(Koin){
        SLF4JLogger()
        modules(koinModule)
    }
}



