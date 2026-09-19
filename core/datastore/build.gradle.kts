plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.hilt)
}

android {
    namespace = "com.owlite.socialexit.datastore"
}

dependencies {
    api(libs.androidx.dataStore)
    api(libs.androidx.dataStore.core)
    api(libs.androidx.dataStore.preferences)
    api(projects.core.model)

    implementation(projects.core.common)

    testImplementation(libs.kotlinx.coroutines.test)
}