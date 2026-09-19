package com.owlite.socialexit.core.data.repository

import com.owlite.socialexit.core.datastore.UserPreferencesDataSource
import com.owlite.socialexit.core.model.data.DarkThemeConfig
import com.owlite.socialexit.core.model.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class OfflineUserDataRepository(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserDataRepository {
    override val userData: Flow<UserData> = userPreferencesDataSource.userData.map { pref ->
        UserData(
            shouldHideOnboarding = pref.shouldHideOnboarding,
            darkThemeConfig = pref.darkThemeConfig
        )
    }

    override suspend fun setShouldHideOnboarding(shouldHide: Boolean) {
        userPreferencesDataSource.setShouldHideOnboarding(shouldHide)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        userPreferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }
}
