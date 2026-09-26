plugins {
    alias(libs.plugins.socialexit.android.feature.impl)
    alias(libs.plugins.socialexit.android.library.compose)
}

android {
    namespace = "com.owlite.socialexit.feature.settings.impl"
    testOptions.animationsDisabled = true
}

dependencies {
    // TODO: check NIA -- import domain, etc
    implementation(projects.feature.settings.api)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.constraintlayout.compose)

    testImplementation(libs.hilt.android.testing)
//    testImplementation(projects.core.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
//    androidTestImplementation(projects.core.testing)

    // TODO: later remove this
    implementation(projects.core.model)
}
