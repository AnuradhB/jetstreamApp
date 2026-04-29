package com.jetstream.app.presentation.dashbaord.domain.usecase

import com.jetstream.app.presentation.dashbaord.domain.model.DashBoardModel
import com.jetstream.app.presentation.dashbaord.domain.repositry.DashboardRepository
import javax.inject.Inject

class GetDashboardUseCase @Inject constructor(
    private val repository: DashboardRepository
) {

    suspend operator fun invoke(): DashBoardModel {

        return repository.getDashboard()
    }
}