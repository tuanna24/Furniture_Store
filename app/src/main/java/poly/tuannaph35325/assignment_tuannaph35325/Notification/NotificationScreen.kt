package poly.tuannaph35325.assignment_tuannaph35325.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class Notification(
    val imageRes: Int,
    val title: String,
    val description: String,
    val tag: String?,
    val tagColor: Color
)

@Composable
fun NotificationScreen(navController: NavController) {
    val notifications = listOf(
        Notification(
            imageRes = R.drawable.bantrang,
            title = "Your order #123456789 has been confirmed",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
            tag = "New",
            tagColor = Color.Green
        ),
        Notification(
            imageRes = R.drawable.den,
            title = "Your order #123456789 has been canceled",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
            tag = null,
            tagColor = Color.Transparent
        ),
        Notification(
            imageRes = R.drawable.coffeetable,
            title = "Discover hot sale furnitures this week.",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
            tag = "HOT!",
            tagColor = Color.Red
        ),
        Notification(
            imageRes = R.drawable.coffeetable,
            title = "Your order #123456789 has been shipped successfully",
            description = "Please help to confirm and rate your order to get 10% discount code for next order.",
            tag = null,
            tagColor = Color.Transparent
        ),
        Notification(
            imageRes = R.drawable.banthap,
            title = "Your order #123456789 has been confirmed",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
            tag = null,
            tagColor = Color.Transparent
        ),
        Notification(
            imageRes = R.drawable.coffeetable,
            title = "Your order #123456789 has been canceled",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec.",
            tag = null,
            tagColor = Color.Transparent
        ),
        Notification(
            imageRes = R.drawable.bantrang,
            title = "Your order #123456789 has been shipped successfully",
            description = "Please help to confirm and rate your order to get 10% discount code for next order.",
            tag = null,
            tagColor = Color.Transparent
        )
    )

    Column (
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Notification",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.size(20.dp)) // To balance the alignment
        }

        LazyColumn {
            items(notifications) { notification ->
                NotificationItem(
                    imageRes = notification.imageRes,
                    title = notification.title,
                    description = notification.description,
                    tag = notification.tag,
                    tagColor = notification.tagColor
                )
            }
        }
    }
}

@Composable
fun NotificationItem(
    imageRes: Int,
    title: String,
    description: String,
    tag: String?,
    tagColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        if (tag != null) {
            Text(
                text = tag,
                color = tagColor,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .background(tagColor.copy(alpha = 0.1f))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNoti() {
    val navController = rememberNavController()
    NotificationScreen(navController)
}
