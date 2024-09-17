import androidx.compose.foundation.Image
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.launch

@Composable
fun CartApp() {
    val productsViewModel = remember { ProductsViewModel(loader = RemoteProductsLoader(httpClient = URLSessionHTTPClient(session = HttpClient.shared), resourceURL = Environment.productsURL)) }
    val cartViewModel = remember { CartViewModel() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold {
        val tabData = listOf("Produtos", "Carrinho")
        val state = remember { mutableStateOf(0) }
        
        Column {
            TabRow(selectedTabIndex = state.value) {
                tabData.forEachIndexed { index, title ->
                    Tab(selected = state.value == index, onClick = {
                        coroutineScope.launch { 
                            state.value = index 
                        }
                    }, text = { Text(title) })
                }
            }
            when (state.value) {
                0 -> ProductsView(viewModel = productsViewModel, onSelection = { product, size ->
                    cartViewModel.select(product, size)
                })
                1 -> CartView(viewModel = cartViewModel, badgeCount = cartViewModel.amountOfProducts)
            }
        }
    }
}