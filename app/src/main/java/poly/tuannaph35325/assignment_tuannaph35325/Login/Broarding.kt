package poly.tuannaph35325.assignment_tuannaph35325.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import poly.tuannaph35325.assignment_tuannaph35325.ui.theme.Assignment_Tuannaph35325Theme

@Composable
fun Greeting(navController: NavController) {
    backGround()
    MakeYour()
    SimpleButton(navController)
}

@Composable
fun backGround() {
    Image(
        painterResource(id = R.drawable.background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
}

@Composable
fun MakeYour() {
    Text(
        text = "MAKE YOUR",
        fontSize = 24.sp,
        modifier = Modifier
            .padding(30.dp, 231.dp)
            .fillMaxWidth(),
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally // căn giữa ngang
    ) {
        Text(
            text = "HOME BEAUTIFUL",
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            modifier = Modifier
                .padding(40.dp, 276.dp)
        )
    }

    Text(
        text = "The best simple place where you" +
                " discover most wonderful furnitures" +
                " and make your home beautiful",
        fontSize = 15.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(59.dp, 349.dp),
    )
}

@Composable
fun SimpleButton(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(108.dp, 150.dp),
        verticalArrangement = Arrangement.Bottom, // căn giữa dọc
        horizontalAlignment = Alignment.CenterHorizontally // căn giữa ngang
    ) {
        Button(
            onClick = {
                navController.navigate("login")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black,
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Get Started", textAlign = TextAlign.Center, fontSize = 18.sp)
        }
    }
}

@Composable
fun LoginScreen() {
    // Nội dung của LoginScreen composable
    Text(text = "Login Screen", fontSize = 24.sp, fontWeight = FontWeight.Bold)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    Assignment_Tuannaph35325Theme {
        Greeting(navController)
    }
}
