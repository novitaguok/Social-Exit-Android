plugins {
    alias(libs.plugins.socialexit.android.feature.impl)
    alias(libs.plugins.socialexit.android.library.compose)
}

android {
    namespace = "com.owlite.socialexit.feature.history.impl"
    testOptions.animationsDisabled = true
}

dependencies {
    implementation(projects.feature.history.api)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.constraintlayout.compose)

    testImplementation(libs.hilt.android.testing)
//    testImplementation(projects.core.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
//    androidTestImplementation(projects.core.testing)\
}
