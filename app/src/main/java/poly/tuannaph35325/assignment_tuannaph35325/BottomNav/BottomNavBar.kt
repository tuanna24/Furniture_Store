package poly.tuannaph35325.assignment_tuannaph35325.BottomNav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.FavoriteScreen
import poly.tuannaph35325.assignment_tuannaph35325.HomeProduct.HomeScreen
import poly.tuannaph35325.assignment_tuannaph35325.Notification.NotificationScreen
import poly.tuannaph35325.assignment_tuannaph35325.Profile.ProfileScreen
import poly.tuannaph35325.assignment_tuannaph35325.R

data class TabItem(
    val unselectedIcon: Int,
    val selectedIcon: Int,
    val content: @Composable (NavController) -> Unit // Chấp nhận NavController như một tham số
)

val tabItems = listOf(
    TabItem(
        unselectedIcon = R.drawable.home_icon,
        selectedIcon = R.drawable.home_dack,
        content = { navController -> HomeScreen(navController) }
    ),
    TabItem(
        unselectedIcon = R.drawable.bookmark_icon,
        selectedIcon = R.drawable.bookmark_dack,
        content = { navController -> FavoriteScreen(navController) }
    ),
    TabItem(
        unselectedIcon = R.drawable.bell_icon,
        selectedIcon = R.drawable.bell_dack,
        content = { navController -> NotificationScreen(navController) }
    ),
    TabItem(
        unselectedIcon = R.drawable.pepor_icon,
        selectedIcon = R.drawable.pepor_dack,
        content = { navController -> ProfileScreen(navController) }
    )
)


@Composable
fun BottomNavBar(navController: NavController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp) // Thêm khoảng trống để tránh chồng lấp với thanh điều hướng dưới
    ) {
        tabItems[selectedTabIndex].content(navController) // Truyền navController vào content của TabItem
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (index == selectedTabIndex) item.selectedIcon else item.unselectedIcon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBottom() {
    var navController = rememberNavController()
    BottomNavBar(navController)
}
