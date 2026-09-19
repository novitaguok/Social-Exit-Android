plugins {
    alias(libs.plugins.socialexit.android.library)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.owlite.socialexit.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

//    implementation(libs.javax.inject)
//
//    testImplementation(projects.core.testing)
}
