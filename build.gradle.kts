plugins {
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "net.radstevee"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-text-serializer-gson:4.16.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "radPublic"
            url = uri("https://maven.radsteve.net/public")

            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("RAD_MAVEN_USER")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("RAD_MAVEN_TOKEN")
            }
        }
    }
}
