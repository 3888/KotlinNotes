import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}
group = "me.kara4uni"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/arrow-kt/arrow-kt/")
}

dependencies {
    implementation("io.arrow-kt:arrow-core-data:0.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    //For runBlockingTest, CoroutineDispatcher etc.
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.5")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
