package com.owlite.socialexit.core.model.data

import androidx.annotation.DrawableRes

data class SettingsGroup(
    val id: String,
    val groupName: String,
    val settingItem: List<SettingItem>
)

sealed interface SettingItem {
    val id: String
    val title: String

    @get:DrawableRes
    val icon: Int
    val detail: String?

    data class NavigationSetting(
        override val id: String,
        override val title: String,
        override val icon: Int,
        override val detail: String? = null
    ) : SettingItem

    data class ToggleSetting(
        override val id: String,
        override val title: String,
        override val icon: Int,
        val isEnabled: Boolean,
        override val detail: String? = null,
    ) : SettingItem
}
