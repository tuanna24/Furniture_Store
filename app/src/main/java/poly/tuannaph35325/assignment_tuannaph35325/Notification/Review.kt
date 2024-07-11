package poly.tuannaph35325.assignment_tuannaph35325.Review

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class Review(
    val reviewerName: String,
    val reviewDate: String,
    val rating: Int,
    val reviewText: String,
    val reviewerImageRes: Int
)

@Composable
fun ReviewScreen(navController: NavController) {

    val itemReview = listOf(
        Review (
            "Bruno Fernandes",
            "20/03/2020",
            R.drawable.star_review,
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price",
            R.drawable.tuan
        ),
        Review (
            "Tracy Mosby",
            "20/03/2020",
            R.drawable.star_review,
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price",
            R.drawable.tuan
        ),
        Review (
            "Tracy Mosby",
            "20/03/2020",
            R.drawable.star_review,
            "Nice Furniture with good delivery. The delivery time is very fast. Then products look like exactly the picture in the app. Besides, color is also the same and quality is very good despite very cheap price",
            R.drawable.tuan
        )
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(), // Sử dụng fillMaxSize để Column chiếm hết kích thước
        verticalArrangement = Arrangement.SpaceBetween, // Đảm bảo các thành phần được phân bố đều
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
                modifier = Modifier
                    .size(25.dp)
                    .clickable { },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Rating & Review",
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bantrang), // sử dụng hình ảnh mới
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Minimal Stand",
                    fontSize = 20.sp,
                    color = Color.Gray
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star1), // sử dụng biểu tượng ngôi sao mới
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.5",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Text(
                    text = "10 reviews",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.size(80.dp)) // Để cân bằng căn chỉnh
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LazyColumn {
                items(itemReview.size) { index ->
                    ReviewScreen(itemReview[index])
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("checkOut")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Write a review",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun ReviewScreen (itemReview : Review) {
    Card(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tuan),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth() // đảm bảo Row chiếm hết chiều ngang
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Căn đều hai bên
            ) {
                Text(
                    text = itemReview.reviewerName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = itemReview.reviewDate,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Image(
                painter = painterResource(id = itemReview.rating),
                contentDescription = null,
            )
            Text(
                text = itemReview.reviewText,
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewReview() {
    val navController = rememberNavController()
    ReviewScreen(navController)
}
