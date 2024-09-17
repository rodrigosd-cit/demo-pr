import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marketplace.ProductsView
import com.example.networkengine.URLSessionHTTPClient
import com.example.ui.theme.MyAppTheme

class CartApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize dependencies
    }
}

@Composable
fun CartAppContent() {
    val productsViewModel: ProductsViewModel = viewModel(factory = ProductsViewModelFactory(RemoteProductsLoader(
        URLSessionHTTPClient(LocalContext.current),
        Environment.productsURL
    )))
    val cartViewModel: CartViewModel = viewModel()

    MyAppTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            content = { padding ->
                TabRow(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Tab(
                        selected = true,
                        onClick = { /*TODO*/ },
                        text = { Text("Produtos") },
                        icon = { Icon(Icons.Default.ShoppingBag, contentDescription = null) }
                    )
                    Tab(
                        selected = false,
                        onClick = { /*TODO*/ },
                        text = { Text("Carrinho") },
                        icon = { BadgeBox(badgeContent = { Text("${cartViewModel.amountOfProducts}") }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = null)
                        }}
                    )
                }
                ProductsView(productsViewModel) { product, size ->
                    cartViewModel.select(product, size)
                }
                CartView(cartViewModel)
            }
        )
    }
}