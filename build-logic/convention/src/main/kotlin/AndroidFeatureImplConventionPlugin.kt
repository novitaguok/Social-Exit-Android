import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.TestOptions
import com.owlite.socialexit.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.Actions.with
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import kotlin.text.get

class AndroidFeatureImplConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "socialexit.android.library")
            apply(plugin = "socialexit.hilt")

            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true
            }

            // TODO: check NIA
            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:designsystem"))

                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.viewmodel.compose").get())
                "implementation"(
                    libs.findLibrary("androidx.hilt.lifecycle.viewmodel.compose").get()
                )
                "implementation"(libs.findLibrary("androidx.navigation3.runtime").get())
                "implementation"(libs.findLibrary("androidx.tracing.ktx").get())

                "androidTestImplementation"(
                    libs.findLibrary("androidx.lifecycle.runtime.testing").get(),
                )
            }
        }
    }
}
