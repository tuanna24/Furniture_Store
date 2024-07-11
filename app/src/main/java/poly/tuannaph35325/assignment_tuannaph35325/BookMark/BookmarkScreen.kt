package poly.tuannaph35325.assignment_tuannaph35325.BookMark

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class ProductFavorite(val name: String, val price: Double, val imageRes: Int)

@Composable
fun FavoriteScreen(navController: NavController) {
    var cart by remember { mutableStateOf(listOf<ProductFavorite>()) }
    var favorites by remember {
        mutableStateOf(
            listOf(
                ProductFavorite("Coffee Table", 50.0, R.drawable.coffeetable),
                ProductFavorite("Coffee Chair", 20.0, R.drawable.ghecao),
                ProductFavorite("Minimal Stand", 25.0, R.drawable.bantrang),
                ProductFavorite("Minimal Desk", 50.0, R.drawable.banthap),
                ProductFavorite("Minimal Lamp", 12.0, R.drawable.den),
                ProductFavorite("Coffee Table", 50.0, R.drawable.coffeetable),
                ProductFavorite("Coffee Chair", 20.0, R.drawable.ghecao),
                ProductFavorite("Minimal Stand", 25.0, R.drawable.bantrang),
                ProductFavorite("Minimal Desk", 50.0, R.drawable.banthap),
                ProductFavorite("Minimal Lamp", 12.0, R.drawable.den)
            )
        )
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
                painterResource(id = R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Favorites",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painterResource(id = R.drawable.bi_cart2),
                contentDescription = null,
                modifier = Modifier.size(25.dp).clickable { navController.navigate("cart") },
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(favorites.size) { index ->
                val productFavorite = favorites[index]
                FavoriteItem(
                    product = productFavorite,
                    onAddToCart = {
                        cart = cart + productFavorite
                    }
                ) {
                    favorites = favorites.toMutableList().also { it.removeAt(index) }
                }
            }
        }

        Button(
            onClick = {
                cart = cart + favorites
                navController.navigate("cart")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 5.dp, end = 5.dp, bottom = 0.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Add all to my cart",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .size(width = 285.dp, height = 30.dp),
            )
        }
//        val navController
//        BottomNavBar(navController = navController)
    }
}

@Composable
fun FavoriteItem(
    product: ProductFavorite,
    onAddToCart: () -> Unit,
    onRemove: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(product.name, fontSize = 14.sp)
                Text("$${product.price}", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.height(84.dp), // Adjust height if necessary
                verticalArrangement = Arrangement.SpaceBetween // Space between icons
            ) {
                IconButton(onClick = onRemove) {
                    Icon(
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = "Remove",
                        modifier = Modifier.size(24.dp)
                    )
                }

                IconButton(onClick = onAddToCart) {
                    Icon(
                        painter = painterResource(id = R.drawable.bag),
                        contentDescription = "Add to cart",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFavorite() {
    var navController = rememberNavController()
    FavoriteScreen(navController)
}
