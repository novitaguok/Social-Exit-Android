import com.owlite.socialexit.SeBuildType

plugins {
    alias(libs.plugins.socialexit.android.application)
    alias(libs.plugins.socialexit.android.application.compose)
    alias(libs.plugins.socialexit.android.application.flavors)
    alias(libs.plugins.socialexit.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.owlite.socialexit"

    defaultConfig {
        applicationId = "com.owlite.socialexit"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = SeBuildType.DEBUG.applicationIdSuffix
        }
        release {
            // TODO: check NIA
            optimization {
                enable = false
            }
        }
    }

    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(projects.feature.home.api)
    implementation(projects.feature.home.impl)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
