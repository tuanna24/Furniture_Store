package poly.tuannaph35325.assignment_tuannaph35325.BookMark

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun CheckOut(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(15.dp)
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
                painter = painterResource(id = R.drawable.left),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.popBackStack()},
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Check Out",
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
        ShippingAddress()
        Payment()
        vanChuyen()
        giaShip()
        button(navController)
    }
}

@Composable
fun ShippingAddress() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Shipping Address",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Image(
            painterResource(id = R.drawable.pen_add),
            contentDescription = "edit dia chi",
            modifier = Modifier
                .size(20.dp)
                .clickable { }
        )
    }
    Card(
        modifier = Modifier
            .padding(top = 0.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Nguyễn Anh Tuấn",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp)
            )
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Text(
                text = "Ngõ 143/1 Xuân Phương, Nam Từ Liêm, Hà Nội",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 20.dp, end = 15.dp)
            )
        }
    }
}

@Composable
fun Payment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Payment",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Image(
            painterResource(id = R.drawable.pen_add),
            contentDescription = "edit dia chi",
            modifier = Modifier
                .size(20.dp)
                .clickable { }
        )
    }
    Card(
        modifier = Modifier
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.payment),
                    contentDescription = "The thanh toan",
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
                Text(
                    text = "***** ***** ***** 6789",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }
        }
    }
}

@Composable
fun vanChuyen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, top = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Delivery method",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Image(
            painterResource(id = R.drawable.pen_add),
            contentDescription = "edit dia chi",
            modifier = Modifier
                .size(20.dp)
                .clickable { }
        )
    }
    Card(
        modifier = Modifier
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(id = R.drawable.ship),
                    contentDescription = "The thanh toan",
                )
                Text(
                    text = "Fast (2-3days)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }
        }
    }
}

@Composable
fun giaShip() {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 25.dp, end = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.LightGray)
            .clickable { /* handle item click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Oder: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivery: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total: ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "0",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun button(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("congats")
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "SUBMIT ORDER",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily.Default,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCheckOut() {
    var navController = rememberNavController()
    CheckOut(navController)
}