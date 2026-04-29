package com.jetstream.app.presentation.dashbaord.data

import com.jetstream.app.presentation.dashbaord.domain.model.DashBoardModel
import com.jetstream.app.presentation.dashbaord.data.dashDTO.DashBoardModelDTO

fun DashBoardModelDTO.toDomain(): DashBoardModel {

    return DashBoardModel(
        Data,
        Message,

        StatusCode,
        Success, Time
    )
}