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
import com.owlite.socialexit.feature.history.api.navigation.HistoryNavKey
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.feature.scripts.api.navigation.ScriptsNavKey
import com.owlite.socialexit.feature.settings.api.navigation.SettingsNavKey
import com.owlite.socialexit.feature.history.api.R as historyR
import com.owlite.socialexit.feature.home.api.R as homeR
import com.owlite.socialexit.feature.scripts.api.R as scriptsR
import com.owlite.socialexit.feature.settings.api.R as settingsR

enum class TopLevelNavItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconRes: Int,
    @StringRes val titleRes: Int,
) {
    HOME(
        selectedIcon = Icons.Filled.Shield,
        unselectedIcon = Icons.Outlined.Shield,
        iconRes = homeR.string.feature_home_api_title,
        titleRes = homeR.string.feature_home_api_title
    ),

    SCRIPTS(
        selectedIcon = Icons.AutoMirrored.Filled.Article,
        unselectedIcon = Icons.AutoMirrored.Outlined.Article,
        iconRes = scriptsR.string.feature_scripts_api_title,
        titleRes = scriptsR.string.feature_scripts_api_title
    ),

    HISTORY(
        selectedIcon = Icons.Filled.History,
        unselectedIcon = Icons.Outlined.History,
        iconRes = historyR.string.feature_history_api_title,
        titleRes = historyR.string.feature_history_api_title
    ),

    SETTINGS(
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        iconRes = settingsR.string.feature_settings_api_title,
        titleRes = settingsR.string.feature_settings_api_title
    )
}

val TOP_LEVEL_NAV_KEYS = mapOf(
    HomeNavKey to TopLevelNavItem.HOME,
    ScriptsNavKey to TopLevelNavItem.SCRIPTS,
    HistoryNavKey to TopLevelNavItem.HISTORY,
    SettingsNavKey to TopLevelNavItem.SETTINGS,
)
