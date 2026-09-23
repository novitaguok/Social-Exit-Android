package com.owlite.socialexit.feature.home.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.feature.home.impl.ArmState
import com.owlite.socialexit.feature.home.impl.HomeScreen
import com.owlite.socialexit.feature.scripts.api.navigation.ScriptsNavKey

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<HomeNavKey> {
        HomeScreen(
            state = ArmState.IDLE,
            onManageAllClick = { navigator.navigate(ScriptsNavKey) }
        )
    }
}
