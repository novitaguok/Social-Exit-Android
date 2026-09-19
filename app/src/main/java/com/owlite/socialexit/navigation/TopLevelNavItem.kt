package com.owlite.socialexit.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.automirrored.outlined.Article
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.ui.graphics.vector.ImageVector
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.feature.home.api.R as homeR

enum class TopLevelNavItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
) {
    HOME(
        selectedIcon = Icons.Filled.Shield,
        unselectedIcon = Icons.Outlined.Shield,
        iconTextId = homeR.string.feature_home_api_title,
        titleTextId = homeR.string.feature_home_api_title
    ),

    SCRIPTS(
        selectedIcon = Icons.AutoMirrored.Filled.Article,
        unselectedIcon = Icons.AutoMirrored.Outlined.Article,
        iconTextId = homeR.string.feature_home_api_title,
        titleTextId = homeR.string.feature_home_api_title
    ),

    HISTORY(
        selectedIcon = Icons.Filled.History,
        unselectedIcon = Icons.Outlined.History,
        iconTextId = homeR.string.feature_home_api_title,
        titleTextId = homeR.string.feature_home_api_title
    ),

    SETTINGS(
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        iconTextId = homeR.string.feature_home_api_title,
        titleTextId = homeR.string.feature_home_api_title
    ),
}

val TOP_LEVEL_NAV_KEYS = mapOf(
    HomeNavKey to TopLevelNavItem.HOME,
)
