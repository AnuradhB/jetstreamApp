package com.jetstream.app.presentation.auth.data

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    var Data: Data,
    var Message: String,
    var StatusCode: Int,
    var Success: Boolean
)
//data class User(
//    val token: String,
//    val userId: String
//)

data class User(
    var Data: Data,
    var Message: String,
    var StatusCode: Int,
    var Success: Boolean
)

data class Data(
    val BrokerageFees: Double,
    val IsSubscribed: Boolean,
    val SubscriptionDetails: SubscriptionDetails,
    val Token: String,
    val UserDetails: UserDetails,
    val UserId: String,
    val Username: String
)

class SubscriptionDetails

data class UserDetails(
    val CountryCode: String,
    val DateOfBirth: String,
    val Email: String,
    val FirstName: String,
    val LastName: String,
    val PhoneNumber: String,
    val TradingExperience: String,
    val UserId: String,
    val profilePic: String
)


