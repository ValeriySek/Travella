plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.app.travella.android"
        minSdk = 25
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":shared"))

    implementation ("androidx.core:core-ktx:1.6.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")


    implementation ("com.google.dagger:hilt-android:2.38.1")
    kapt  ("com.google.dagger:hilt-compiler:2.38.1")


    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation("com.google.android.gms:play-services-maps:18.0.2")
    implementation("com.squareup.picasso:picasso:2.8")
}