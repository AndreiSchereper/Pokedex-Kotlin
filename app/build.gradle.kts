// Apply necessary plugins
plugins {
    alias(libs.plugins.android.application) // Android application plugin
    alias(libs.plugins.kotlin.android) // Kotlin plugin for Android
    alias(libs.plugins.hilt.android) // Hilt plugin for dependency injection
    id("org.jetbrains.kotlin.kapt") // Kotlin annotation processing tool (used for libraries like Hilt and Room)
}

android {
    namespace = "nl.schereper.andrei" // Unique identifier for your app (package name)
    compileSdk = 34 // Compile SDK version (Android 14)

    defaultConfig {
        applicationId = "nl.schereper.andrei" // Application ID
        minSdk = 23 // Minimum SDK version (Android 6.0)
        targetSdk = 34 // Target SDK version (Android 14)
        versionCode = 1 // Application version code
        versionName = "1.0" // Application version name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // Test runner for instrumentation tests
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Disable code shrinking for release builds
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), // Default ProGuard rules
                "proguard-rules.pro" // Custom ProGuard rules file
            )
        }
    }

    buildFeatures {
        compose = true // Enable Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get() // Specify the Compose compiler version
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Java language level compatibility
        targetCompatibility = JavaVersion.VERSION_11 // Java language level compatibility
    }

    kotlinOptions {
        jvmTarget = "11" // Kotlin JVM target version
    }
}

dependencies {
    // Core Android libraries
    implementation(libs.androidx.core.ktx) // Android KTX extensions
    implementation(libs.androidx.appcompat) // AppCompat for backward compatibility
    implementation(libs.material) // Material Design components

    // Jetpack Compose libraries
    implementation(libs.compose.ui) // Core Compose UI library
    implementation(libs.compose.material) // Material Design components for Compose
    implementation(libs.compose.ui.tooling.preview) // Tooling support for Compose previews

    // Lifecycle and Activity libraries
    implementation(libs.lifecycle.runtime.ktx) // Lifecycle extensions for Kotlin
    implementation(libs.activity.compose) // Activity integration with Compose

    // Navigation library for Compose
    implementation(libs.navigation.compose) // Navigation support for Compose

    // Hilt for dependency injection
    implementation(libs.hilt.android) // Hilt core library
    kapt(libs.hilt.android.compiler) // Annotation processor for Hilt

    // Networking libraries
    implementation(libs.retrofit) // Retrofit for network requests
    implementation(libs.moshi.converter) // Moshi converter for JSON parsing
    implementation(libs.logging.interceptor) // Logging interceptor for debugging HTTP requests

    // Room for local database
    implementation(libs.room.runtime) // Room runtime library
    kapt(libs.room.compiler) // Annotation processor for Room
    implementation(libs.room.ktx) // Kotlin extensions for Room

    // Paging library for pagination support
    implementation(libs.paging.runtime) // Paging runtime library
    implementation(libs.paging.compose) // Paging integration with Compose

    // Coroutines for asynchronous programming
    implementation(libs.coroutines.core) // Core Coroutines library
    implementation(libs.coroutines.android) // Coroutines support for Android

    // Coil Compose for image loading
    implementation(libs.coil.compose) // Image loading with Coil Compose

    // Debugging tools for Compose
    debugImplementation(libs.compose.ui.tooling) // Tooling support for debugging Compose UI
    debugImplementation(libs.compose.ui.test.manifest) // Test manifest for Compose UI testing

    // Testing libraries
    testImplementation(libs.junit) // JUnit for unit testing
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit for instrumentation tests
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
}