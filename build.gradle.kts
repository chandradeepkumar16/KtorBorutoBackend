
val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion : String by project

plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.31"
}

group = "com.chandradeepdev"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")


    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-call-logging-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")

    implementation ("io.insert-koin:koin-ktor:$koinVersion")
    // SLF4J Logger
    implementation ("io.insert-koin:koin-logger-slf4j:$koinVersion")

    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
