plugins {
    alias(libs.plugins.socialexit.android.feature.api)
}

android {
    namespace = "com.owlite.socialexit.feature.scripts.api"
}

dependencies {
    api(projects.core.navigation)
}
