package com.jetstream.app.presentation.dashbaord.presenting

import com.jetstream.app.presentation.dashbaord.domain.model.DashBoardModel

data class DashboardState(
    val isLoading: Boolean = false,
    val data: DashBoardModel? = null,


    val error: String = ""
)