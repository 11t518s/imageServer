import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
}

group = "com.image"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.h2database:h2")
	implementation("io.awspring.cloud:spring-cloud-starter-aws:2.4.1")
	implementation("io.awspring.cloud:spring-cloud-starter-aws-secrets-manager-config:2.4.0")
	implementation("com.amazonaws:aws-java-sdk-s3:1.12.174")
	implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
	implementation(platform("software.amazon.awssdk:bom:2.20.56"))
	implementation("software.amazon.awssdk:s3")
	implementation("software.amazon.awssdk:netty-nio-client")

	implementation("aws.sdk.kotlin:s3:1.0.0")
	implementation("aws.sdk.kotlin:secretsmanager:1.0.0")
	implementation("aws.smithy.kotlin:http-client-engine-okhttp:0.30.0")
	implementation("aws.smithy.kotlin:http-client-engine-crt:0.30.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
