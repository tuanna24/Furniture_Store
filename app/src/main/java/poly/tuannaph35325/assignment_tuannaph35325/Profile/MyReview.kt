package poly.tuannaph35325.assignment_tuannaph35325.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class ReviewItems(
    val imageProduct: Int,
    val nameProduct: String,
    val priceProduct: Double,
    val date: String,
    val starReview: Int,
    val tite: String,
)

@Composable
fun MyReview(navController: NavController) {
    val reviewItems = remember {
        mutableStateListOf(
            ReviewItems(
                R.drawable.coffeetable,
                "Coffee Table",
                50.0,
                "24/02/2024",
                R.drawable.star_review,
                "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
            ),
            ReviewItems(
                R.drawable.coffeetable,
                "Coffee Table",
                50.0,
                "24/02/2024",
                R.drawable.star_review,
                "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
            ),
            ReviewItems(
                R.drawable.coffeetable,
                "Coffee Table",
                50.0,
                "24/02/2024",
                R.drawable.star_review,
                "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
            ),
            ReviewItems(
                R.drawable.coffeetable,
                "Coffee Table",
                50.0,
                "24/02/2024",
                R.drawable.star_review,
                "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price"
            )
        )
    }

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
                painterResource(id = R.drawable.left),
                contentDescription = null,
                modifier = Modifier.size(25.dp).clickable { navController.navigate("profileScreen") },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "My Reviews",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        LazyColumn {
            items(reviewItems) { item ->
                ReviewItemsRow(item)
            }
        }
    }
}

@Composable
fun ReviewItemsRow(item: ReviewItems) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = item.imageProduct),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = item.nameProduct,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "$${item.priceProduct}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = item.starReview),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = item.date,
                    color = androidx.compose.ui.graphics.Color.Gray,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = item.tite,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewReview() {
    var navController = rememberNavController()
    MyReview(navController)
}
