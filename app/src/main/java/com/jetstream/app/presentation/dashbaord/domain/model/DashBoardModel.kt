package com.jetstream.app.presentation.dashbaord.domain.model

data class DashBoardModel(
    val Data: Data,
    val Message: String,
    val StatusCode: Int,
    val Success: Boolean,
    val Time: Time
)

data class Data(
    val Courses: List<Course>,
    val HolidayTitle: String,
    val Stocks: List<Stock>,
    val TodayIsHoliday: Boolean,
    val TotalPortfolio: List<TotalPortfolio>,
    val Watchlists: List<Any>
)

data class Time(
    val CoursesMs: Int,
    val PortfolioMs: Int,
    val StocksMs: Int,
    val TotalMs: Int,
    val WatchlistMs: Int
)

data class Course(
    val Attachment: String,
    val CourseId: String,
    val Description: String,
    val DurationInMin: String,
    val LessonId: String,
    val LessonName: String,
    val Overview: String,
    val ReleaseDate: String,
    val Thumbnail: String,
    val TotalLessons: Int,
    val VideoUrl: String
)

data class Stock(
    val ChangePercent: Double,
    val Exchange: String,
    val IsIntraday: Boolean,
    val IsUp: Boolean,
    val LogoUrl: String,
    val Name: String,
    val Price: Double,
    val Symbol: String
)

data class TotalPortfolio(
    val BaseValue: Int,
    val ProfitToday: Int,
    val ProfitTodayPercent: Int,
    val Timeframe: String,
    val TotalPortfolio: Int
)