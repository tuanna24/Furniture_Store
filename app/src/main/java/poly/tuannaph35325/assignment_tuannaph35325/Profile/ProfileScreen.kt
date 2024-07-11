package poly.tuannaph35325.assignment_tuannaph35325.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.BookMark.FavoriteItem
import poly.tuannaph35325.assignment_tuannaph35325.R

data class SetTingItem(
    val title: String,
    val content: String,
    val iconResId: Int,
    val funtion : String
)

@Composable
fun ProfileScreen(navController: NavController) {
    val settingsItems = listOf(
        SetTingItem("My orders", "Already have 10 orders", R.drawable.right_black, "myOrder"),
        SetTingItem("Shipping Addresses", "03 Addresses", R.drawable.right_black, "shippingAddress"),
        SetTingItem("Payment Method", "You have 2 cards", R.drawable.right_black, "paymentMethod"),
        SetTingItem("My reviews", "Reviews for 5 items", R.drawable.right_black, "myReviews"),
        SetTingItem("Setting", "Notification, Password, FAQ, Contact", R.drawable.right_black, "settings"),
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable { /* handle search click */ },
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Profile",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painterResource(id = R.drawable.log_out),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable { navController.navigate("bottomNavBar") },
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        TopNotifi()

        LazyColumn {
            items(settingsItems.size) { index ->
                ItemSeting1(settingsItems[index], navController)
            }
        }
    }
}

@Composable
fun TopNotifi() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Image(
                painterResource(id = R.drawable.tuan),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Nguyễn Anh Tuấn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Tuanna24@gmail.com",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
        }
    }
}

@Composable
fun ItemSeting1(item: SetTingItem, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray)
            .clickable { navController.navigate(item.funtion) } // Sử dụng route để điều hướng
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = item.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = item.content
                )
            }
            Image(
                painterResource(id = item.iconResId),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                contentScale = ContentScale.FillBounds,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfile() {
    var navController = rememberNavController()
    ProfileScreen(navController)
}
