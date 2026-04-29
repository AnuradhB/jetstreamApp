package com.jetstream.app.presentation.dashbaord.domain.repositry

import com.jetstream.app.presentation.dashbaord.domain.model.DashBoardModel

interface DashboardRepository {

    suspend fun getDashboard(): DashBoardModel


}