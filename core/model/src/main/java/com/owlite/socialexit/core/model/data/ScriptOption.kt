package com.owlite.socialexit.core.model.data

import androidx.annotation.DrawableRes

data class ScriptOption(
    @DrawableRes val iconRes: Int,
    val title: String,
    val desc: String,
    val category: String,
    val successRate: Float,
    val isActive: Boolean,
)
