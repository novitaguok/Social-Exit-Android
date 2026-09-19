plugins {
    alias(libs.plugins.socialexit.android.feature.impl)
    alias(libs.plugins.socialexit.android.library.compose)
}

android {
    namespace = "com.owlite.socialexit.feature.onboarding.impl"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.feature.onboarding.api)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.hilt.android.testing)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    // TODO: check NiA
//    androidTestImplementation(projects.core.testing)
}
