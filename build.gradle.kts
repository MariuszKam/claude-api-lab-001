plugins {
    java
    application
}

group = "dev.claudefoundations"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.anthropic:anthropic-java:3.10.0")
    implementation(platform("com.fasterxml.jackson:jackson-bom:2.23.0"))
    implementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "dev.claudefoundations.lab.Main"
}

tasks.test {
    useJUnitPlatform()
}
