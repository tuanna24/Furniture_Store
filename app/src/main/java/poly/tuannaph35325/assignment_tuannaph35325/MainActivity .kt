package poly.tuannaph35325.assignment_tuannaph35325

import PaymentMethod
import android.media.Image
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.Cart
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.CheckOut
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.Congats
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.FavoriteScreen
import poly.tuannaph35325.assignment_tuannaph35325.BottomNav.BottomNavBar
import poly.tuannaph35325.assignment_tuannaph35325.HomeProduct.HomeScreen
import poly.tuannaph35325.assignment_tuannaph35325.HomeProduct.ProductDetails
import poly.tuannaph35325.assignment_tuannaph35325.Login.Greeting
import poly.tuannaph35325.assignment_tuannaph35325.Login.Login
import poly.tuannaph35325.assignment_tuannaph35325.Login.SignUpScreen
import poly.tuannaph35325.assignment_tuannaph35325.Notification.AddShippingScreen
import poly.tuannaph35325.assignment_tuannaph35325.Profile.AddPaymentMethod
import poly.tuannaph35325.assignment_tuannaph35325.Profile.MyOrder
import poly.tuannaph35325.assignment_tuannaph35325.Profile.MyReview

import poly.tuannaph35325.assignment_tuannaph35325.Profile.ProfileScreen
import poly.tuannaph35325.assignment_tuannaph35325.Profile.SettingsScreen
import poly.tuannaph35325.assignment_tuannaph35325.Profile.ShippingAddress
import poly.tuannaph35325.assignment_tuannaph35325.ui.theme.Assignment_Tuannaph35325Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_Tuannaph35325Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)

                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    val navController = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Chứa BottomNavBar và NavHost
        BottomNavBar(navController = navController)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "greeting"
    ) {

        composable("mainScreen") { MainScreen(navController = navController) }
        composable("greeting") { Greeting(navController = navController) }
        composable("login") { Login(navController = navController) }
        composable("signUpScreen") { SignUpScreen(navController = navController) }

        composable("bottomNavBar") { BottomNavBar(navController = navController) }


        composable("favoriteScreen") { FavoriteScreen(navController = navController) }
        composable("cart") { Cart(navController = navController) }
        composable("checkOut") { CheckOut(navController = navController) }
        composable("congats") { Congats(navController = navController) }

        composable("addShippingScreen") { AddShippingScreen(navController = navController)}

        composable("profileScreen") { ProfileScreen(navController = navController) }
        composable("myOrder") { MyOrder(navController = navController) }
        composable("shippingAddress") { ShippingAddress(navController = navController) }
        composable("paymentMethod") { PaymentMethod(navController = navController) }
        composable("myReviews") { MyReview(navController = navController) }
        composable("settings") { SettingsScreen(navController = navController) }
        composable("addPaymentMethod") { AddPaymentMethod(navController = navController) }

        composable("productItem") { ProductDetails( navController = navController) }
    }
}
