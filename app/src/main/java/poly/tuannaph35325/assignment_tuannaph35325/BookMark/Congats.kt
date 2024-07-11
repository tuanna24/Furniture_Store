package poly.tuannaph35325.assignment_tuannaph35325.BookMark

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun Congats (navController: NavController) {
    Column (
        modifier = Modifier
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Image(
            painterResource(id = R.drawable.back_notifi),
            contentDescription = null,
            modifier = Modifier
                .size(260.dp)
        )
        Image(
            painterResource(id = R.drawable.tick_notifi) ,
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(25.dp)
        )
        SignUpBTN(navController)
    }
}

@Composable
fun SignUpBTN(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp, 70.dp),
        verticalArrangement = Arrangement.Bottom,// căn giữa dọc
        horizontalAlignment = Alignment.CenterHorizontally// căn giữa nagng
    ) {
        Button(
            onClick = {
                /* Su kien OnClick*/
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier

        ) {
            Text(
                text = "Track orders",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .size(width = 285.dp, height = 30.dp),
            )
        }
        Button(
            onClick = {
                /* Su kien OnClick*/
                navController.navigate("bottomNavBar")
            },
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, color = Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            
        ) {
            Text(
                text = "BACK TO HOME",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .size(width = 285.dp, height = 30.dp),
                color = Color.Black
            )
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewNotifi () {
    var navController = rememberNavController()
    Congats(navController)
}