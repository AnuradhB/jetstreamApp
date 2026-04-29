package com.jetstream.app.utils

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import com.jetstream.app.R

val AppFontFamily = FontFamily(
    Font(R.font.acid_grotesk_bold, FontWeight.Bold),
    Font(R.font.acid_grotesk_bold, FontWeight.Bold)
)

val AppFontNormalFamily = FontFamily(
    Font(R.font.acid_grotesk_normal, FontWeight.Normal),
    Font(R.font.acid_grotesk_normal, FontWeight.Medium),
)

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = AppFontFamily
    ),
    bodyMedium = TextStyle(
        fontFamily = AppFontFamily
    ),
    titleLarge = TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = FontWeight.Bold
    ),
    labelLarge = TextStyle(
        fontFamily = AppFontFamily
    )
)