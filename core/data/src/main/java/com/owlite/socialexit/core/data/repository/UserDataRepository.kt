package com.owlite.socialexit.core.data.repository

import com.owlite.socialexit.core.model.data.DarkThemeConfig
import com.owlite.socialexit.core.model.data.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    val userData: Flow<UserData>

    suspend fun setShouldHideOnboarding(shouldHide: Boolean)
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)
}
