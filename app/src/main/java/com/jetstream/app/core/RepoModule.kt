package com.jetstream.app.core

import com.jetstream.app.presentation.auth.data.api.repository.AuthRepositoryImpl
import com.jetstream.app.presentation.dashbaord.domain.repositry.DashboardRepository
import com.jetstream.app.presentation.dashbaord.data.repositery.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindDashboardRepository(
        impl: DashboardRepositoryImpl
    ): DashboardRepository
}