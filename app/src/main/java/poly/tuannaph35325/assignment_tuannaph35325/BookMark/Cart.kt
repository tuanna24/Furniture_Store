package poly.tuannaph35325.assignment_tuannaph35325.BookMark

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class CartItem(
    val name: String,
    val price: Double,
    val imageRes: Int,
    var quality: Int = 1,
)

@Composable
fun Cart(navController: NavController) {
    val cartItems = remember {
        mutableStateListOf(
            CartItem("Minimal Stand", 25.0, R.drawable.bantrang),
            CartItem("Coffee Table", 20.0, R.drawable.coffeetable),
            CartItem("Minimal Desk", 50.0, R.drawable.banthap),
            CartItem("Minimal Stand", 25.0, R.drawable.bantrang),
            CartItem("Coffee Table", 20.0, R.drawable.coffeetable),
            CartItem("Minimal Desk", 50.0, R.drawable.banthap),
            CartItem("Minimal Stand", 25.0, R.drawable.bantrang),
            CartItem("Coffee Table", 20.0, R.drawable.coffeetable),
            CartItem("Minimal Desk", 50.0, R.drawable.banthap)
        )
    }
    var totalAmount by remember { mutableStateOf(cartItems.sumOf { it.price * it.quality }) }
    var promoCode by remember { mutableStateOf("") }

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
                painter = painterResource(id = R.drawable.left),
                contentDescription = null,
                modifier = Modifier.size(20.dp).clickable { navController.popBackStack() },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "My Cart",
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

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(cartItems) { item ->
                CartItemRow(item = item, onQuantityChange = { newQuantity ->
                    item.quality = newQuantity
                    totalAmount = cartItems.sumOf { it.price * it.quality }
                })
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        PromoCodeField(
            promoCode = promoCode,
            onPromoCodeChange = { promoCode = it },
            onApplyPromoCode = { /* Handle promo code application */ }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total: ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = " $${"%.2f".format(totalAmount)}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

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
                text = "Check out",
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
fun PromoCodeField(
    promoCode: String,
    onPromoCodeChange: (String) -> Unit,
    onApplyPromoCode: () -> Unit,
) {
    OutlinedTextField(
        value = promoCode,
        onValueChange = onPromoCodeChange,
        label = { Text("Enter your promo code") },
        trailingIcon = {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Black)
            ) {
                IconButton(onClick = onApplyPromoCode) {
                    Icon(
                        painter = painterResource(id = R.drawable.right),
                        contentDescription = "Apply Promo Code",
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun CartItemRow(item: CartItem, onQuantityChange: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.name,
                fontSize = 18.sp
            )
            Text(
                text = "$${item.price}",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onQuantityChange(item.quality + 1) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = null,
                        Modifier.size(15.dp)
                    )
                }
                Text(
                    item.quality.toString(),
                    fontSize = 18.sp
                )
                IconButton(onClick = { if (item.quality > 1) onQuantityChange(item.quality - 1) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.minus_sign),
                        contentDescription = null,
                        Modifier.size(15.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier.height(70.dp), // Adjust height if necessary
            verticalArrangement = Arrangement.SpaceBetween // Space between icons
        ) {
            Image(
                painterResource(id = R.drawable.delete),
                contentDescription = null,
                Modifier.size(25.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCart() {
    var navController = rememberNavController()
    Cart(navController)
}
