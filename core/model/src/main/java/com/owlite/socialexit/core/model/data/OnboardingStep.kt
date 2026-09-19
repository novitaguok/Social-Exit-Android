package com.owlite.socialexit.core.model.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingStep(
    val stepNumber: Int,
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int,
    @DrawableRes val iconRes: Int
)
