package com.example.tugas11

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tugas11.ui.pages.claimReward.RewardActivity
import com.example.tugas11.ui.pages.menu.MenuActivity
import com.example.tugas11.ui.pages.profile.ProfileActivity
import com.example.tugas11.ui.pages.signIn.SignInScreen
import com.example.tugas11.ui.pages.signUp.SignUpScreen
import com.example.tugas11.ui.pages.splash.SplashScreen
import com.example.tugas11.ui.pages.otp.OTPScreen

sealed class Route(val name: String) {
    object SplashScreen : Route("Splash")
    object SignInScreen : Route("SignIn")
    object SignUpScreen : Route("SignUp")
    object MenuScreen : Route("Menu")
    object ProfileScreen : Route("Profile")
    object RewardScreen : Route("Reward")
    object OTPScreen : Route("OTP")
}

@Composable
fun MyNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Route.SplashScreen.name
    ) {
        composable(route = Route.SplashScreen.name) {
            SplashScreen(
                onLoginClick = {
                    navHostController.navigate(Route.SignInScreen.name)
                },
                onRegisterClick = {
                    navHostController.navigate(Route.SignUpScreen.name)
                }
            )
        }

        composable(route = Route.SignInScreen.name) {
            SignInScreen(
                onSignInClick = {
                    navHostController.navigate(Route.MenuScreen.name)
                },
                onSignUpClick = {
                    navHostController.navigate(Route.SignUpScreen.name)
                }
            )
        }

        composable(route = Route.SignUpScreen.name) {
            SignUpScreen(
                onSignUpClick = {
                    navHostController.navigate(Route.OTPScreen.name)
                },
                onSignInClick = {
                    navHostController.navigate(Route.SignInScreen.name)
                }
            )
        }

        composable(route = Route.OTPScreen.name) {
            OTPScreen(
                onOTPSubmit = {
                    navHostController.navigate(Route.MenuScreen.name)
                }
            )
        }

        composable(route = Route.MenuScreen.name) {
            MenuActivity(navHostController)
        }

        composable(route = Route.RewardScreen.name) {
            RewardActivity(navHostController)
        }

        composable(route = Route.ProfileScreen.name) {
            ProfileActivity(navHostController)
        }
    }
}