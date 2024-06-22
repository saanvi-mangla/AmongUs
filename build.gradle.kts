plugins {
    id("java")
}

group = "unjoinable.github.io"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("--enable-preview")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}


dependencies {
    implementation("net.minestom:minestom-snapshots:0f81bc31ff")
}
