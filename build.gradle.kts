import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java.sourceCompatibility = JavaVersion.VERSION_1_8

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.50"
    application
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation ( platform("software.amazon.awssdk:bom:2.17.24"))
    implementation ("software.amazon.awssdk:s3")
    implementation ("software.amazon.awssdk:polly")

    implementation ("com.googlecode.soundlibs:jlayer:1.0.1-1")
    implementation ("com.mirego.dsl:ssml:1.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation(platform("org.junit:junit-bom:5.7.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.24")

}

application {
    // Define the main class for the application
    mainClassName = "dev.surratt.koach.AppKt"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
