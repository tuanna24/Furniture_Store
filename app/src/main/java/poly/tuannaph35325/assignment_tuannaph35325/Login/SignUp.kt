package poly.tuannaph35325.assignment_tuannaph35325.Login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.API.AuthViewModel
import poly.tuannaph35325.assignment_tuannaph35325.R
import poly.tuannaph35325.assignment_tuannaph35325.ui.theme.Assignment_Tuannaph35325Theme

@Composable
fun SignUpScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {

//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }

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
                        BorderStroke(1.dp, Color.Black), shape = CircleShape
                    )
                    .padding(15.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(16.dp))
            FixedWidthLine()
        }
    }
    chuChay()
    SigUp()
    SignUpBTN(navController)
}

@Composable
fun FixedWidthLine() {
    Canvas(
        modifier = Modifier
            .width(75.dp)
            .height(0.dp)
    ) {
        drawLine(
            color = Color.Black, start = Offset.Zero, end = Offset(size.width, 0f), strokeWidth = 2f
        )
    }
}

@Composable
fun chuChay() {
    Column(
        modifier = Modifier.padding(30.dp, 160.dp)
    ) {
        Text(
            text = "WELCOME", fontSize = 30.sp, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SigUp() {
    Column(
        modifier = Modifier.padding(0.dp, 230.dp)
    ) {
        // Name Input
        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp, horizontal = 30.dp)
        )

        //Email
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp, horizontal = 30.dp)
        )

        // Password Input
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            trailingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp, horizontal = 30.dp)
        )

        // Confirm Password Input
        var confirmPassword by remember { mutableStateOf("") }
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            trailingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp, horizontal = 30.dp)
        )
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
                navController.navigate("login")
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
        Text(
            text = "Already have an account? SIGN IN",
            Modifier.clickable {
                navController.navigate("login")
            },
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    var navController = rememberNavController()
    Assignment_Tuannaph35325Theme {
        SignUpScreen(navController)
    }
}
