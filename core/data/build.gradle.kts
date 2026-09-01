plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.owlite.socialexit.core.data"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)


    // TODO: check NiA
    api(projects.core.common)
//    api(projects.core.database)
//    api(projects.core.datastore)
    api(projects.core.network)
//
//    implementation(projects.core.analytics)
//    implementation(projects.core.notifications)
//
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
//    testImplementation(projects.core.datastoreTest)
//    testImplementation(projects.core.testing)
}
