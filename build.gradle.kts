plugins {
    id("org.jetbrains.intellij") version "0.5.0"
    kotlin("jvm") version "1.4.10"
}

group = "com.dsazup"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

intellij {
    version = "2020.2"
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
}