import io.quarkus.gradle.tasks.QuarkusNative

plugins {
    kotlin("jvm")
    id("io.quarkus")
    id("org.jetbrains.kotlin.plugin.allopen")
}

group = "com.jccf.application"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val quarkusPlatformGroupId: String by ext
val quarkusPlatformArtifactId: String by ext
val quarkusPlatformVersion: String by ext
val postgresVersion: String by ext

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":project-core"))

    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jsonb")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
    named<QuarkusNative>("buildNative") {
        isEnableHttpUrlHandler = true
    }
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}