plugins {
    alias(libs.plugins.socialexit.android.feature.api)
}

android {
    namespace = "com.owlite.socialexit.feature.home.api"
}

dependencies {
    api(projects.core.navigation)
}
