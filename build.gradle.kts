plugins {
    id("org.jetbrains.intellij") version "0.5.0"
    kotlin("jvm") version "1.4.10"
}

group = "com.dsazup"
version = "1.0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

intellij {
    version = "2020.3"
}