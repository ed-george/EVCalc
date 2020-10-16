import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("maven-publish")
}
group = "org.dynamium.evcalc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Dynamium/EVCalc")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("EVCALC_GHP_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("EVCALC_GHP_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("evcalc") {
            from(components["java"])
        }
    }
}

dependencies {
    testImplementation(kotlin("test-junit"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}