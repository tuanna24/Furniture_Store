package poly.tuannaph35325.assignment_tuannaph35325.Notification

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
import poly.tuannaph35325.assignment_tuannaph35325.Profile.SettingTextField
import poly.tuannaph35325.assignment_tuannaph35325.R

@Composable
fun AddShippingScreen(navController: NavController) {

    var fullName by remember {
        mutableStateOf("Ex: Bruno Pham")
    }

    var address by remember {
        mutableStateOf("Ex: 25 Robert Latouche Street")
    }

    var Zipcode by remember {
        mutableStateOf("Nguyễn Anh Tuấn")
    }

    var Country by remember {
        mutableStateOf("Việt Nam")
    }

    var City by remember {
        mutableStateOf("Hà Nội")
    }
    var District by remember {
        mutableStateOf("Nam Từ Liêm")
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
                modifier = Modifier
                    .size(25.dp)
                    .clickable { navController.navigate("shippingAddress") },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Add shipping address",
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(bottom = 10.dp, top = 35.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Name", fullName)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Address", address)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            Column(modifier = Modifier.padding(start = 20.dp,10.dp)) {
                SettingTextField("Zipcode (Postal Code)", Zipcode)
            }
        }

        Card (
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.LightGray)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Country",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = Country
                    )
                }
                Image(
                    painterResource(id = R.drawable.down),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }

        Card (
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.LightGray)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "City",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = City
                    )
                }
                Image(
                    painterResource(id = R.drawable.down),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }



        Card (
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.LightGray)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "District",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = District
                    )
                }
                Image(
                    painterResource(id = R.drawable.down),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "SAVE ADDRESS",
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAdd() {
    var navController = rememberNavController()
    AddShippingScreen(navController)
}