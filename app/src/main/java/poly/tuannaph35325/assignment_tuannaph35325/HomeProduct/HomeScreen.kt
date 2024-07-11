package poly.tuannaph35325.assignment_tuannaph35325.HomeProduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import poly.tuannaph35325.assignment_tuannaph35325.R

data class Product(val imageRes: Int, val name: String, val price: String)

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))

    ) {
        Box(

        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
            )
            Icon(
                painter = painterResource(id = R.drawable.bag),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .size(24.dp)
                    .background(
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable { navController.navigate("productItem") }
                    .padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.price,
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ProductList(products: List<Product>, navController: NavController) {
    val state = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = state,
        verticalItemSpacing = 10.dp,

    ) {
        items(products) {
            ProductCard(product = it, navController = navController)
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
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
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Make home\nBEAUTIFUL",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Image(
                painterResource(id = R.drawable.bi_cart2),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {navController.navigate("")},
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        val items = listOf(
            Pair(R.drawable.star2, "Popular"),
            Pair(R.drawable.chair, "Chair"),
            Pair(R.drawable.table, "Table"),
            Pair(R.drawable.armchair, "Armchair"),
            Pair(R.drawable.bed, "Bed"),
            Pair(R.drawable.lamp, "Lamp")
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            items(items) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .clickable { }
                            .background(color = Color(0xFFE0E0E0))
                            .padding(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = item.first),
                            contentDescription = null,
                            modifier = Modifier
                                .size(45.dp)
                                .padding(5.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = item.second,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }

    }
}

@Composable
fun HomeScreen(navController : NavController) {
    Column {
        TopBar(navController)
        Spacer(modifier = Modifier.height(0.dp))

        val products = listOf(
            Product(R.drawable.den, "Black Simple Lamp", "$12.00"),
            Product(R.drawable.bantrang, "Minimal Stand", "$25.00"),
            Product(R.drawable.ghecao, "Coffee Chair", "$35.00"),
            Product(R.drawable.banthap, "Simple Desk", "$45.00"),
            Product(R.drawable.den, "Black Simple Lamp", "$12.00"),
            Product(R.drawable.bantrang, "Minimal Stand", "$25.00"),
            Product(R.drawable.ghecao, "Coffee Chair", "$35.00"),
            Product(R.drawable.banthap, "Simple Desk", "$45.00"),
        )
        ProductList(products, navController)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome() {
    var navController = rememberNavController()
    HomeScreen(navController)
}