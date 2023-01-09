plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("release/debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ryccoatika.imagetotext"
        minSdk = 21
        targetSdk = 33
        versionCode = 2
        versionName = "1.0.1"

        testInstrumentationRunner = "androidx.intro_1.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".dev"
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0")
    implementation("androidx.core:core-ktx:1.9.0")

    // ui
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // firebase product
    implementation("com.google.firebase:firebase-core:21.1.1")
    implementation("com.google.firebase:firebase-analytics-ktx:21.2.0")
    implementation("com.google.android.gms:play-services-vision:20.1.3")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition:18.0.2")

    // https://github.com/CanHub/Android-Image-Croppe
    implementation("com.github.CanHub:Android-Image-Cropper:4.0.0")

    // room
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-rxjava2:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")

    // reactivex
    implementation("io.reactivex.rxjava2:rxjava:2.2.20")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")

    // kotlin coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // koin
    implementation("io.insert-koin:koin-android:3.1.4")

    // Leak Canary
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.10")

    // Lottie
    implementation("com.airbnb.android:lottie:4.2.1")

    // Jetpack Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")

    implementation("com.google.android.play:core-ktx:1.8.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
}
