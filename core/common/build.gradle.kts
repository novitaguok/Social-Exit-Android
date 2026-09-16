plugins {
    alias(libs.plugins.socialexit.jvm.library)
    alias(libs.plugins.socialexit.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
}
