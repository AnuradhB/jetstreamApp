package com.jetstream.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.jetstream.app.newLatest.screens.LoginScreen




import com.jetstream.app.ui.theme.ZenceyNewTheme


// ✅ Routes (best practice)
object NavRoutes {
    const val LOGIN = "login"
    const val HOME = "home"
//    const val OTP = "otp"
//    const val CHAT_LIST = "chatList"
//    const val CHAT_DETAIL = "chat_detail"
//    const val SETTING = "setting"
//    const val PROFILE = "profile"
//    const val EDIT_PROFILE = "edit_profile"
//
}
@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.LOGIN
    ) {

        // 🔐 Login Screen
        composable(NavRoutes.LOGIN) {

//            val viewModel: LoginViewModel = hiltViewModel()
//            val state = viewModel.state.collectAsState().value

            LoginScreen(
//                state = state,
//                onLoginClick = { email, pass ->
//                    viewModel.login(email, pass)
//                }
            )

            // 🔥 Navigate on success
//            LaunchedEffect(state) {
//                if (state is LoginState.Success) {
//                    navController.navigate(NavRoutes.HOME) {
//                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
//                    }
//                }
//            }
        }

        // 🏠 Home Screen
        composable(NavRoutes.HOME) {
//            HomeScreen()
        }
    }
}

fun composable(home: Any, function: Any) {}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview() {
    ZenceyNewTheme {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen(
//                    state = LoginState.Idle,
//                    onLoginClick = { _, _ -> }
                )
            }

            composable("home") {
                Text("Home Screen")
            }
        }
    }
}