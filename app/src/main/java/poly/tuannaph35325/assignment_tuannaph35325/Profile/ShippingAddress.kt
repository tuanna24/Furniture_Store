package poly.tuannaph35325.assignment_tuannaph35325.Profile

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class ItemShip(
    val name: String,
    val content: String,
    val img: Int,
    val chek: String,
    val full: String,
)

@Composable
fun ShippingAddress(navController: NavController) {
    var itemShip = listOf(
        ItemShip(
            "Bruno Fernandes",
            "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
            R.drawable.pen_add,
            "Use as default payment method",
            "addShippingScreen"
        ),
        ItemShip(
            "Bruno Fernandes",
            "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
            R.drawable.pen_add,
            "Use as default payment method",
            "addShippingScreen"
        ),
        ItemShip(
            "Bruno Fernandes",
            "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
            R.drawable.pen_add,
            "Use as default payment method",
            "addShippingScreen"
        )
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addPaymentMethod") },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon), // Replace with your icon
                    contentDescription = "Add Payment Method",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { navController.navigate("AddShippingScreen") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    text = "Shipping address",
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

            LazyColumn {
                items(itemShip.size) { index ->
                    ShipperItem(itemShip[index], navController)
                }
            }
        }
    }
}

@Composable
fun ShipperItem(itemShip: ItemShip, navController: NavController) {
    var checkBox by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(1.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = checkBox,
                onCheckedChange = { checkBox = it },
                modifier = Modifier
                    .padding(end = 10.dp)  // Adjust this padding to provide space between Checkbox and Text
            )
            Text(text = itemShip.chek)
        }

        Card(
            modifier = Modifier
                .padding(top = 1.dp, start = 10.dp, end = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.LightGray)
                .clickable { navController.navigate(itemShip.full) }
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()  // Make the Row fill the width of the parent
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = itemShip.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Image(painterResource(id = itemShip.img), contentDescription = null)
                }
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.Gray,
                    thickness = 1.dp
                )
                Text(
                    text = itemShip.content,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAs() {
    val navController = rememberNavController()
    ShippingAddress(navController)
}
