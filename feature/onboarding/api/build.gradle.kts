plugins {
    alias(libs.plugins.socialexit.android.feature.api)
}

android {
    namespace = "com.owlite.socialexit.feature.onboarding.api"
}

dependencies {
    api(projects.core.navigation)
}
