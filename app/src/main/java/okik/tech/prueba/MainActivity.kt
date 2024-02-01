package okik.tech.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import okik.tech.prueba.ui.theme.PruebaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val challengeViewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTheme {
                // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(ScrollState(0))
                        ) {
                            val categories = challengeViewModel.categories.collectAsStateWithLifecycle().value
                            if (categories.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(16.dp))
                                categories.forEach {  category ->
                                    Card(modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp)
                                        .padding(horizontal = 16.dp)
                                    ) {
                                        Text(
                                            modifier = Modifier.align(Alignment.CenterHorizontally),
                                            text = category.name,
                                            fontSize = 24.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(16.dp))
                                }
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaTheme {
        Greeting("Android")
    }
}