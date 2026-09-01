import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.TestOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.Actions.with
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidFeatureImplConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "socialexit.android.library")
            apply(plugin = "socialexit.hilt")

            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true
            }

            // TODO: check NIA
        }
    }
}
