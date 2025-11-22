plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.coryson"

val defaultVersion = "0.1.0"
val envVersion = System.getenv("PLUGIN_VERSION")
version = envVersion?.takeIf { it.isNotBlank() } ?: defaultVersion

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

val mainPluginClass = "de.coryson.coordinates.main"

tasks.processResources {
    val props = mapOf(
        "name" to project.name,
        "version" to project.version,
        "main" to mainPluginClass,
        "apiVersion" to "1.20"
    )
    inputs.properties(props)

    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.shadowJar {
    archiveClassifier.set("")
    mergeServiceFiles()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
