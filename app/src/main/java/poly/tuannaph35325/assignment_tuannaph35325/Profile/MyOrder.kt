package poly.tuannaph35325.assignment_tuannaph35325.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class ItemMyOder(
    val No1: String,
    val Date: String,
    val Quantity: String,
    val Total: String,
    val Detail: String,
    val Delivered: String,
)


@Composable
fun MyOrder(navController: NavController) {
    var itemMyOder = listOf(
        ItemMyOder(
            "Order No238562312",
            "20/03/2020",
            "03",
            "$150",
            "Detail",
            "Delivered"
        ),
        ItemMyOder(
            "Order No238562312",
            "20/03/2020",
            "03",
            "$150",
            "Detail",
            "Delivered"
        ),
        ItemMyOder(
            "Order No238562312",
            "20/03/2020",
            "03",
            "$150",
            "Detail",
            "Delivered"
        ),
        ItemMyOder(
            "Order No238562312",
            "20/03/2020",
            "03",
            "$150",
            "Detail",
            "Delivered"
        ),
        ItemMyOder(
            "Order No238562312",
            "20/03/2020",
            "03",
            "$150",
            "Detail",
            "Delivered"
        )
    )


    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.left),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable { navController.navigate("profileScreen") },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "My Order",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()  // Make the Row fill the width of the parent
                .padding(10.dp, bottom = 20.dp, top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivered",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Processing",
                fontSize = 18.sp
            )
            Text(
                text = "Canceled",
                fontSize = 18.sp
            )
        }
        LazyColumn {
            items(itemMyOder.size) { index ->
                ViewItem(itemMyOder[index])
            }
        }
    }

}

@Composable
fun ViewItem(itemMyOder: ItemMyOder) {
    Card(
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(170.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()  // Make the Row fill the width of the parent
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = itemMyOder.No1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp)
                )
                Text(
                    text = itemMyOder.Date,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp)
                )
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Quantity: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("${itemMyOder.Quantity}")
                        }
                    },
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 15.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        append("Total Amount: ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("${itemMyOder.Total}")
                        }
                    },
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 20.dp, end = 15.dp)
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()  // Make the Row fill the width of the parent
                    .padding(end = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box  (
                    modifier = Modifier
                        .padding(start = 0.dp, bottom = 20.dp, top = 1.dp)
                        .background(Color.Black)
                        .width(100.dp)
                        .height(36.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = itemMyOder.Detail,
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                }
                Text(
                    text = itemMyOder.Delivered,
                    color = Color.Green,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 20.dp, top = 10.dp)
                        .width(100.dp)
                        .height(36.dp),
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previewoder() {
    var navController = rememberNavController()
    MyOrder(navController)
}