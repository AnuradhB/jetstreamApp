package com.jetstream.app.presentation.dashbaord.presenting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jetstream.app.R
import com.jetstream.app.presentation.dashbaord.domain.model.Course
import com.jetstream.app.presentation.dashbaord.domain.model.Stock
import com.jetstream.app.ui.theme.JetStreamTheme
import com.jetstream.app.utils.AppFontFamily
import com.jetstream.app.utils.AppFontNormalFamily
import com.valentinilk.shimmer.shimmer

@Composable
fun HomeScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val fontF = FontFamily(
        Font(R.font.acid_grotesk_bold, FontWeight.Normal),
        Font(R.font.acid_grotesk_bold, FontWeight.Bold)
    )

    val fontFNormal = FontFamily(
        Font(R.font.acid_grotesk_normal, FontWeight.Normal),
        Font(R.font.acid_grotesk_light, FontWeight.Bold)
    )

    val data by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadDashboard()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        item {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.profile_circle),
                    modifier = Modifier
                        .size(60.dp)
                        .drawBehind {
                            drawRoundRect(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFF6C63FF),
                                        Color(0xFF00C6FF)
                                    )
                                ),
                                style = Stroke(width = 1.5.dp.toPx()),
                                cornerRadius = CornerRadius(40.dp.toPx())
                            )
                        },
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {

                    Text(
                        "Welcome Back",
                        fontSize = 16.sp,
                        fontFamily = fontFNormal
                    )

                    Text(
                        "Anuradha",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = fontF
                    )
                }
            }
        }

        item {
            HeadOfList("Learn")
        }

        item {

            val items = data.data?.Data?.Courses ?: emptyList()

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                items(items.size) { index ->

                    CourseList(items[index])
                }
            }
        }

        item {
            HeadOfList("Wishlist")
        }

        item {

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                items(1) {
                    Wishlist()
                }
            }
        }

        item {
            HeadOfList("Explore")
        }

        val stockItems = data.data?.Data?.Stocks ?: emptyList()

        items(stockItems.size) { index ->

            ExploreFun(stockItems[index])
        }
    }
}

@Composable
fun CourseList(items: Course) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    Column {

        Box(
            modifier = Modifier
                .padding(top = 10.dp, end = 10.dp)
                .height(200.dp)
                .width(300.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {

            AsyncImage(
                model = items.Thumbnail,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,

                onSuccess = {
                    isLoading = false
                },

                onError = {
                    isLoading = false
                }
            )

            if (isLoading) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .shimmer()
                        .background(Color.DarkGray)
                )
            }
        }

        if (isLoading) {

            Column(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            ) {

                Box(
                    modifier = Modifier
                        .width(180.dp)
                        .height(18.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmer()
                        .background(Color.DarkGray)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmer()
                        .background(Color.DarkGray)
                )
            }

        } else {

            Text(
                items.LessonName,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .width(250.dp),
                fontSize = 16.sp,
                fontFamily = AppFontFamily,
                fontWeight = FontWeight.Bold
            )

            Text(
                items.DurationInMin,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 16.sp,
                fontFamily = AppFontNormalFamily,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ExploreFun(stocks: Stock) {

    Card(
        modifier = Modifier
            .padding(top = 10.dp)
            .border(
                1.dp,
                Color.LightGray,
                RoundedCornerShape(20.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.profile_circle),
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        1.dp,
                        Color.LightGray,
                        RoundedCornerShape(30.dp)
                    ),
                contentDescription = ""
            )

            Column(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .weight(1f)
            ) {

                Text(
                    stocks.Symbol,
                    fontFamily = AppFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    stocks.Name,
                    fontFamily = AppFontNormalFamily,
                    fontSize = 16.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    "$${stocks.Price}",
                    fontFamily = AppFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    "${stocks.ChangePercent}%",
                    fontFamily = AppFontNormalFamily,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun HeadOfList(title: String) {

    Row(
        modifier = Modifier.padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            title,
            fontFamily = AppFontFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            "View All",
            fontFamily = AppFontNormalFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}

@Composable
fun Wishlist() {

    Card(
        modifier = Modifier
            .padding(top = 10.dp)
            .border(
                1.dp,
                Color.LightGray,
                RoundedCornerShape(20.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column {

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .width(190.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.profile_circle),
                    modifier = Modifier.size(60.dp),
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {

                    Text(
                        "AA",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = AppFontFamily
                    )

                    Text(
                        "ABC Inc",
                        fontSize = 16.sp,
                        fontFamily = AppFontFamily
                    )
                }
            }

            Text(
                "$12.0",
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 10.dp),
                fontFamily = AppFontFamily,
                fontWeight = FontWeight.Bold
            )

            Text(
                "+2.50%",
                fontSize = 16.sp,
                modifier = Modifier.padding(
                    start = 10.dp,
                    bottom = 10.dp
                ),
                fontFamily = AppFontFamily
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeScreen() {

    JetStreamTheme {

        HomeScreen()
    }
}