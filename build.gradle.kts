// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version = "1.9.0"

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

plugins {
    id("com.diffplug.spotless") version ("5.14.0")
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }

    apply {
        plugin("com.diffplug.spotless")
    }

    spotless {

        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }

        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
            ktlint("0.41.0").userData(mapOf("disabled_rules" to "no-wildcard-imports"))
        }
    }
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}
