plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.hilt)
    id("kotlinx-serialization")
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.owlite.socialexit.core.network"
}

dependencies {
    api(projects.core.common)
    api(projects.core.model)

    implementation(libs.kotlinx.serialization.json)
    // TODO: see NiA
//    implementation(libs.okhttp.logging)
//    implementation(libs.retrofit.core)
//    implementation(libs.retrofit.kotlin.serialization)

    testImplementation(libs.kotlinx.coroutines.test)
}
