package com.jetstream.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetstream.app.security.SecureTokenManager
import com.jetstream.app.presentation.BottomNAvMainScreen


import com.jetstream.app.presentation.auth.LoginScreen




import com.jetstream.app.ui.theme.JetStreamTheme


// ✅ Routes (best practice)
object NavRoutes {
    const val AUTH_CHECK = "auth_check"
    const val LOGIN = "login"
    const val HOME = "home"
    const val BOTTOM_NAV = "bottom_nav"
}



@Composable
fun AppNavGraph(
    secureTokenManager: SecureTokenManager
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.AUTH_CHECK
    ) {

        // 🔐 AUTH CHECK (AUTO REDIRECT)
        composable(NavRoutes.AUTH_CHECK) {
            AuthCheckScreen(secureTokenManager, navController)
        }

        // 🔐 LOGIN SCREEN
        composable(NavRoutes.LOGIN) {

            LoginScreen(
                onSuccess = {
                    navController.navigate(NavRoutes.BOTTOM_NAV) {
                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        // 🏠 HOME (optional)
        composable(NavRoutes.HOME) {
            Text("Home Screen")
        }

        // 🔥 BOTTOM NAV MAIN SCREEN
        composable(NavRoutes.BOTTOM_NAV) {
            BottomNAvMainScreen()
        }
    }
}
















//@Composable
//fun AppNavGraph() {
//
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = NavRoutes.LOGIN
//    ) {
//
//        // 🔐 Login Screen
//        composable(NavRoutes.LOGIN) {
//
////            val viewModel: LoginViewModel = hiltViewModel()
////            val state = viewModel.state.collectAsState().value
//
//            LoginScreen(
//                onSuccess = { navController.navigate(NavRoutes.BotomNav) }
//
////                state = state,
////                onLoginClick = { email, pass ->
////                    viewModel.login(email, pass)
////                }
//            )
//
//            // 🔥 Navigate on success
////            LaunchedEffect(state) {
////                if (state is LoginState.Success) {
////                    navController.navigate(NavRoutes.HOME) {
////                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
////                    }
////                }
////            }
//        }
//        composable(NavRoutes.LOGIN) {
//
////            val viewModel: LoginViewModel = hiltViewModel()
////            val state = viewModel.state.collectAsState().value
//
//            LoginScreen(
//                onSuccess = { navController.navigate(NavRoutes.BotomNav) }
//
////                state = state,
////                onLoginClick = { email, pass ->
////                    viewModel.login(email, pass)
////                }
//            )
//
//            // 🔥 Navigate on success
////            LaunchedEffect(state) {
////                if (state is LoginState.Success) {
////                    navController.navigate(NavRoutes.HOME) {
////                        popUpTo(NavRoutes.LOGIN) { inclusive = true }
////                    }
////                }
////            }
//        }
//
//        // 🏠 Home Screen
//        composable(NavRoutes.HOME) {
////            HomeScreen()
//        }
//        // 🏠 Home Screen
//        composable(NavRoutes.BotomNav) {
//            BottomNAvMainScreen() // 👈 your bottom navigation UI
//                }
//    }
//}

//fun composable(home: Any, function: Any) {}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview() {
    JetStreamTheme {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen(
//                    state = LoginState.Idle,
                    onSuccess = { navController.navigate(NavRoutes.BOTTOM_NAV) }
                )
            }

//            composable("home") {
//                Text("Home Screen")
//            }
//
//            composable(NavRoutes.BotomNav) {
//                BottomNAvMainScreen() // 👈 your bottom navigation UI
//            }
        }
    }
}




@Composable
fun AuthCheckScreen(
    secureTokenManager: SecureTokenManager,
    navController: NavHostController
) {

    LaunchedEffect(Unit) {

        val isLoggedIn = !secureTokenManager.getToken().isNullOrEmpty()

        if (isLoggedIn) {
            navController.navigate(NavRoutes.BOTTOM_NAV) {
                popUpTo(NavRoutes.AUTH_CHECK) { inclusive = true }
            }
        } else {
            navController.navigate(NavRoutes.LOGIN) {
                popUpTo(NavRoutes.AUTH_CHECK) { inclusive = true }
            }
        }
    }

    Text("Loading...")
}