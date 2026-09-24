package com.owlite.socialexit.feature.settings.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.feature.settings.api.navigation.SettingsNavKey
import com.owlite.socialexit.feature.settings.impl.SettingsScreen

fun EntryProviderScope<NavKey>.settingsEntry(navigator: Navigator) {
    entry<SettingsNavKey> {
        SettingsScreen()
    }
}