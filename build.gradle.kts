import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.8.21"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

group = "ir.fallahpoor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.21")
    testImplementation("org.mockito:mockito-inline:4.1.0")
    testImplementation("org.antlr:antlr4-runtime:4.9.3")
}

application {
    mainClass.set("KotloxKt")
}

tasks.test {
    useJUnit()
}

tasks.koverXmlReport {
    isEnabled = false
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
