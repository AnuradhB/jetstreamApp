package com.jetstream.app.presentation.dashbaord.data.remote

import com.jetstream.app.presentation.dashbaord.data.dashDTO.DashBoardModelDTO
import retrofit2.http.GET

interface DashboardApiService {

    @GET("Dashboard/GetDashboardData")
    suspend fun getDashboard(): DashBoardModelDTO

//    @GET("banners")
//    suspend fun getBanners(): List<BannerDto>
//
//    @GET("orders")
//    suspend fun getOrders(): List<OrderDto>
}