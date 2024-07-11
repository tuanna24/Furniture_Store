package poly.tuannaph35325.assignment_tuannaph35325.Profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

@Composable
fun SettingsScreen(navController: NavController) {
    var name by remember { mutableStateOf("Bruno Pham") }
    var email by remember { mutableStateOf("bruno203@gmail.com") }
    var password by remember { mutableStateOf("**********") }
    var salesNotification by remember { mutableStateOf(true) }
    var newArrivalsNotification by remember { mutableStateOf(false) }
    var deliveryStatusNotification by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
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
                    .clickable { navController.navigate("profileScreen") },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Setting",
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

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Personal Information",
                fontSize = 16.sp,
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
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Name", name)
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Email", email)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Password",
                fontSize = 16.sp,
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
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Password", password)
            }
        }

        Text(
            text = "Notifications",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(10.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            NotificationSettingRow("Sales", salesNotification) { salesNotification = it }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            NotificationSettingRow("New arrivals", newArrivalsNotification) { newArrivalsNotification = it }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Delivery status changes", fontSize = 16.sp, modifier = Modifier.padding(10.dp))
            }
        }

        Text(
            text = "Help Center",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(10.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 15.dp, end = 10.dp,),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "FAQ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Image(
                    painterResource(id = R.drawable.right_black), // Replace with your drawable resource
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Composable
fun SettingTextField(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(text = label, color = Color.Gray)
        BasicTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            enabled = false // Makes the field read-only
        )
    }
}

@Composable
fun NotificationSettingRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 16.sp, modifier = Modifier.padding(start = 20.dp))
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen() {
    var navController = rememberNavController()
    SettingsScreen(navController)
}
