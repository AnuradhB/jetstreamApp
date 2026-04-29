package com.jetstream.app.presentation.dashbaord.data.repositery

import com.jetstream.app.presentation.dashbaord.domain.model.DashBoardModel
import com.jetstream.app.presentation.dashbaord.domain.repositry.DashboardRepository
import com.jetstream.app.presentation.dashbaord.data.remote.DashboardApiService
import com.jetstream.app.presentation.dashbaord.data.toDomain
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val api: DashboardApiService
) : DashboardRepository {

    override suspend fun getDashboard(): DashBoardModel {
        return api.getDashboard().toDomain()
    }

}