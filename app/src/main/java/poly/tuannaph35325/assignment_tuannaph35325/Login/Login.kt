package poly.tuannaph35325.assignment_tuannaph35325.Login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
fun Login(navController: NavController) {
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(65.dp),
        verticalArrangement = Arrangement.Top,// căn giữa dọc
        horizontalAlignment = Alignment.CenterHorizontally// căn giữa nagng
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            FixedWidthLine()
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painterResource(id = R.drawable.group),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .border(
                        BorderStroke(1.dp, Color.Black),
                        shape = CircleShape
                    )
                    .padding(15.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(16.dp))
            FixedWidthLine()
        }
    }
    Hello()
    editEmail()
    editPass()
    FogotPass()
    Loginbtn(navController)
}


@Composable
fun Hello() {
    Column(
        modifier = Modifier.padding(30.dp, 160.dp)
    ) {
        Text(
            text = "Hello",
            fontSize = 30.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "WELCOME BACK",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun editEmail () {
    var email by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(0.dp, 278.dp)
    ) {
        OutlinedTextField(
            value = email, onValueChange = { newValue ->
                email = newValue
            },
            label = { Text(text = "Email") },
            modifier = Modifier
                .size(width = 390.dp, height = 60.dp)
                .padding(30.dp, 0.dp)
        )
    }
}

@Composable
fun editPass () {
    Column (
        modifier = Modifier.padding(0.dp, 360.dp)
    ) {
        var pass by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = pass,
            onValueChange = { newValu2 ->
                pass = newValu2
            },
            label = { Text(text = "Pass Work")},
            trailingIcon = { Icon(Icons.Default.Lock, contentDescription = null)},
            modifier = Modifier
                .size(width = 390.dp, height = 60.dp)
                .padding(30.dp, 0.dp)
        )
    }
}

@Composable
fun FogotPass() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 280.dp),
        verticalArrangement = Arrangement.Bottom,// căn giữa dọc
        horizontalAlignment = Alignment.CenterHorizontally// căn giữa nagng
    ) {
        Text(
            text = "Forgot Password",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun Loginbtn(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp, 150.dp),
        verticalArrangement = Arrangement.Bottom,// căn giữa dọc
        horizontalAlignment = Alignment.CenterHorizontally// căn giữa nagng
    ) {
        Button(
            onClick = {
                /* Su kien OnClick*/
                      navController.navigate("bottomNavBar")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black,
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Log in",
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
                navController.navigate("signUpScreen")
            },
            colors = ButtonDefaults.buttonColors(
                Color.White,
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "SIGN UP",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .size(width = 80.dp, height = 30.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LogoPreview() {
    var navController = rememberNavController()
    Assignment_Tuannaph35325Theme {
        Login(navController)
    }
}