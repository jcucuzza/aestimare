val group: String by project
val artifact: String by project
val version: String by project

plugins {
	java
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.projectlombok:lombok:1.18.24")

	annotationProcessor("org.projectlombok:lombok:1.18.24")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.postgresql:postgresql:42.3.5")
	
	testCompileOnly("org.projectlombok:lombok:1.18.24")

	testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

	testImplementation(platform("org.junit:junit-bom:5.9.1"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
}

java.sourceCompatibility = JavaVersion.VERSION_11

tasks.withType<JavaCompile>() {
	options.encoding = "UTF-8"
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
}

springBoot {
	mainClass.set("com.ae.landfill.LandfillApplication")
}