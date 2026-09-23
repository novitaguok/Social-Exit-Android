package com.owlite.socialexit.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.core.navigation.toEntries
import com.owlite.socialexit.feature.home.api.navigation.HomeNavKey
import com.owlite.socialexit.feature.home.impl.navigation.homeEntry
import com.owlite.socialexit.feature.scripts.api.navigation.ScriptsNavKey
import com.owlite.socialexit.feature.scripts.impl.navigation.scriptsEntry
import com.owlite.socialexit.navigation.TOP_LEVEL_NAV_KEYS
import com.owlite.socialexit.navigation.TopLevelNavItem

@Composable
fun SeApp(
    appState: SeAppState,
    modifier: Modifier
) {
    val navigator = remember(appState.navigationState) { Navigator(appState.navigationState) }
    val bottomNavItems = listOf(
        TopLevelNavItem.HOME,
        TopLevelNavItem.SCRIPTS,
        TopLevelNavItem.HISTORY,
        TopLevelNavItem.SETTINGS
    )
    val currentTab =
        TOP_LEVEL_NAV_KEYS[appState.navigationState.currentTopLevelKey]
            ?: TopLevelNavItem.HOME

    Surface {
        Scaffold(
            modifier = modifier.background(color = SocialExitTheme.colors.background),
            floatingActionButton = {
                if (currentTab == TopLevelNavItem.HOME) {
                    FloatingActionButton(
                        shape = CircleShape,
                        containerColor = SocialExitTheme.colors.primary,
                        onClick = { /* TODO: dialog to create custom script */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add script"
                        )
                    }
                }
            },
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEach { tab ->
                        val selected = currentTab == tab

                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                when (tab) {
                                    TopLevelNavItem.HOME -> navigator.navigate(HomeNavKey)
                                    TopLevelNavItem.SCRIPTS -> navigator.navigate(ScriptsNavKey)
                                    TopLevelNavItem.HISTORY -> TODO()
                                    TopLevelNavItem.SETTINGS -> TODO()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector =
                                        if (selected) tab.selectedIcon
                                        else tab.unselectedIcon,
                                    contentDescription = stringResource(tab.iconTextId)
                                )
                            },
                            label = { Text(text = stringResource(tab.titleTextId)) },
                        )
                    }
                }
            }
        ) { padding ->
            val navigator = remember { Navigator(appState.navigationState) }
            val entryProvider = entryProvider {
                homeEntry(navigator)
                scriptsEntry(navigator)
            }

            Column(
                modifier = Modifier.padding(padding)
            ) {
                NavDisplay(
                    entries = appState.navigationState.toEntries(entryProvider),
                    onBack = { navigator.goBack() },
                    transitionSpec = { EnterTransition.None togetherWith ExitTransition.None },
                    popTransitionSpec = { EnterTransition.None togetherWith ExitTransition.None }
                )
            }
        }
    }
}
