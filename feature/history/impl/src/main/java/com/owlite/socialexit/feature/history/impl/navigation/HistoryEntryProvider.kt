package com.owlite.socialexit.feature.history.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.feature.history.api.navigation.HistoryNavKey
import com.owlite.socialexit.feature.history.impl.HistoryScreen

fun EntryProviderScope<NavKey>.historyEntry(navigator: Navigator) {
    entry<HistoryNavKey> {
        HistoryScreen()
    }
}
