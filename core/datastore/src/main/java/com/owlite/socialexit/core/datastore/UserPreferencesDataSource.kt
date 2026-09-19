package com.owlite.socialexit.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.owlite.socialexit.core.datastore.UserPreferencesDataSource.PreferencesKeys.DARK_THEME_CONFIG
import com.owlite.socialexit.core.datastore.UserPreferencesDataSource.PreferencesKeys.SHOULD_HIDE_ONBOARDING
import com.owlite.socialexit.core.model.data.DarkThemeConfig
import com.owlite.socialexit.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<Preferences>
) {
    private object PreferencesKeys {
        val SHOULD_HIDE_ONBOARDING = booleanPreferencesKey("should_hide_onboarding")
        val DARK_THEME_CONFIG = stringPreferencesKey("dark_theme_config")
    }

    val userData: Flow<UserData> = userPreferences.data.map { pref ->
        UserData(
            shouldHideOnboarding = pref[SHOULD_HIDE_ONBOARDING] ?: false,
            darkThemeConfig = when (pref[DARK_THEME_CONFIG]) {
                DarkThemeConfig.FOLLOW_SYSTEM.name -> DarkThemeConfig.FOLLOW_SYSTEM
                DarkThemeConfig.LIGHT.name -> DarkThemeConfig.LIGHT
                else -> DarkThemeConfig.DARK
            }
        )
    }

    suspend fun setShouldHideOnboarding(shouldHide: Boolean) {
        userPreferences.edit { pref ->
            pref[SHOULD_HIDE_ONBOARDING] = shouldHide
        }
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        userPreferences.edit { pref ->
            pref[DARK_THEME_CONFIG] = darkThemeConfig.name
        }
    }
}
