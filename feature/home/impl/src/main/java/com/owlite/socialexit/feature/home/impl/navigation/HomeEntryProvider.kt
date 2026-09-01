package com.owlite.socialexit.feature.home.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.feature.home.impl.HomeScreen

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<HomeNavKey> {
        HomeScreen()
    }
}
