package com.owlite.socialexit.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.owlite.socialexit.core.data.util.NetworkMonitor
import com.owlite.socialexit.core.navigation.NavigationState
import com.owlite.socialexit.core.navigation.rememberNavigationState
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.navigation.TOP_LEVEL_NAV_KEYS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberSeAppState(
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): SeAppState {
    val navigationState = rememberNavigationState(HomeNavKey, TOP_LEVEL_NAV_KEYS.keys)

    return remember(
        navigationState,
        coroutineScope,
        networkMonitor
    ) {
        SeAppState(
            navigationState = navigationState,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor
        )
    }
}

@Stable
class SeAppState(
    val navigationState: NavigationState,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {
    val isOffline = networkMonitor.isOnline
        .map(transform = Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )
}
