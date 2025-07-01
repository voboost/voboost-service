pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.2.0"
        id("com.android.library") version "8.2.0"
        id("org.jetbrains.kotlin.android") version "1.9.20"
        id("org.jetbrains.kotlin.plugin.parcelize") version "1.9.20"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "voboost-service"

// Include voboost-config as a project dependency if it exists locally
val voboostConfigPath = "../voboost-config"
if (file(voboostConfigPath).exists()) {
    includeBuild(voboostConfigPath)
}
