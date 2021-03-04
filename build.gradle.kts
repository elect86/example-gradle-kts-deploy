plugins {
    java
    `maven-publish`
}

group = "io.repsy.example"
version = "1.0"

repositories {
    mavenCentral()
}

publishing {

    repositories {
        /*
            this will fetch `repsyUsername` and `repsyPassword` from:
            - gradle.properties file (in your home, it must not be under VCS!)
            - command line arguments
            - environment variables
            - or a combination of those options
         */
        maven {
            name = "repsy"
            url = uri("https://repo.repsy.io/mvn/MyRepsyUsername/MyRepositoryName")
            credentials(PasswordCredentials::class)
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
