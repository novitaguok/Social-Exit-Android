package com.owlite.socialexit

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor
import org.gradle.kotlin.dsl.invoke

@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType
}

@Suppress("EnumEntryName")
enum class SeFlavor(val dimensions: FlavorDimension, val applicationIdSuffix: String? = null) {
    demo(FlavorDimension.contentType, applicationIdSuffix = ".demo"),
    prod(FlavorDimension.contentType)
}

fun configureFlavors(
    commonExtension: CommonExtension,
    flavorConfigurationBlock: ProductFlavor.(flavor: SeFlavor) -> Unit = {}
) {
    commonExtension.apply {
        FlavorDimension.entries.forEach { flavorDimension ->
            flavorDimensions += flavorDimension.name
        }

        productFlavors {
            SeFlavor.entries.forEach { seFlavor ->
                register(seFlavor.name) {
                    dimension = seFlavor.dimensions.name
                    flavorConfigurationBlock(this, seFlavor)
                    if (commonExtension is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (seFlavor.applicationIdSuffix != null) {
                            applicationIdSuffix = seFlavor.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}
