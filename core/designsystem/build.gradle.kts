plugins {
    alias(libs.plugins.socialexit.android.library)
    alias(libs.plugins.socialexit.android.library.compose)
}

android {
    namespace = "com.owlite.socialexit.core.designsystem"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.navigationSuite)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)

    implementation(libs.androidx.compose.ui.text.google.fonts)
    implementation(libs.coil.kt.compose)

    // TODO: check NIA
    testImplementation(libs.hilt.android.testing)
}
