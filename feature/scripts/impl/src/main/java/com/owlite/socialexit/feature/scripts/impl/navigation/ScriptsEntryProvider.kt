package com.owlite.socialexit.feature.scripts.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.feature.scripts.api.navigation.ScriptsNavKey
import com.owlite.socialexit.feature.scripts.impl.ScriptsScreen

fun EntryProviderScope<NavKey>.scriptsEntry(navigator: Navigator) {
    entry<ScriptsNavKey> {
        ScriptsScreen()
    }
}
