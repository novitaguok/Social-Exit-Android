plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.hilt)
}

android {
    namespace = "com.owlite.socialexit.datastore"
}

dependencies {
    api(libs.androidx.datastore)
    api(projects.core.model)

    implementation(projects.core.common)
    
    testImplementation(libs.kotlinx.coroutines.test)
}