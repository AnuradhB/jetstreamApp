package com.jetstream.app.presentation.dashbaord.data.dashDTO

import com.jetstream.app.presentation.dashbaord.domain.model.Data
import com.jetstream.app.presentation.dashbaord.domain.model.Time

data class DashBoardModelDTO
    (
    val Data: Data,
    val Message: String,
    val StatusCode: Int,
    val Success: Boolean,
    val Time: Time
            )