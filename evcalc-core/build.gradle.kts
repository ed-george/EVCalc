import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("maven-publish")
}
group = "org.dynamium.evcalc"
version = "1.0-beta1.1"

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
    testImplementation("io.kotest:kotest-runner-junit5:4.3.2") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:4.3.2") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:4.3.2") // for kotest property test
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}