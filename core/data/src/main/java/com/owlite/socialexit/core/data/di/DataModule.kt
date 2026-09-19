package com.owlite.socialexit.core.data.di

import com.owlite.socialexit.core.data.repository.OfflineUserDataRepository
import com.owlite.socialexit.core.data.repository.UserDataRepository
import com.owlite.socialexit.core.data.util.ConnectivityManagerNetworkMonitor
import com.owlite.socialexit.core.data.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor
    ): NetworkMonitor

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: OfflineUserDataRepository
    ): UserDataRepository
}
