plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.android.library.compose)
}

android {
    namespace = "com.owlite.socialexit.core.ui"
}

dependencies {
    api(projects.core.designsystem)
    api(projects.core.model)
    implementation(libs.androidx.constraintlayout)

//    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}
