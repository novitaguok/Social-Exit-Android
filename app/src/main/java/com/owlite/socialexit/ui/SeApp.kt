package com.owlite.socialexit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.owlite.socialexit.core.designsystem.theme.SocialExitTheme
import com.owlite.socialexit.core.navigation.Navigator
import com.owlite.socialexit.core.navigation.toEntries
import com.owlite.socialexit.feature.home.impl.navigation.homeEntry
import com.owlite.socialexit.navigation.TopLevelNavItem

@Composable
fun SeApp(
    appState: SeAppState,
    modifier: Modifier
) {
    val bottomNavItems = listOf(
        TopLevelNavItem.HOME,
        TopLevelNavItem.SCRIPTS,
        TopLevelNavItem.HISTORY,
        TopLevelNavItem.SETTINGS
    )
    var currentTab by rememberSaveable { mutableStateOf(TopLevelNavItem.HOME) }

    Surface {
        Scaffold(
            modifier = modifier.background(color = SocialExitTheme.colors.background),
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEach { tab ->
                        val selected = currentTab == tab

                        NavigationBarItem(
                            selected = selected,
                            onClick = { currentTab = tab },
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
            }

            Column(
                modifier = Modifier.padding(padding)
            ) {
                NavDisplay(
                    entries = appState.navigationState.toEntries(entryProvider),
                    onBack = { navigator.goBack() }
                )
            }
        }
    }
}
