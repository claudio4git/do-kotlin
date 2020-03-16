pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }

    val quarkusPluginVersion: String by settings
    val kotlinVersion: String by settings

    plugins {
        id("io.quarkus") version quarkusPluginVersion
        id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
    }
}

rootProject.name = "hexagon-quarkus-gradle-mult-projects"

include("project-application")
include("project-core")
