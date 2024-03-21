package uqac.dim.tryhardstart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uqac.dim.tryhardstart.ui.screens.bottomNavigation.BottomNavigationBar
import uqac.dim.tryhardstart.ui.screens.inscriptionPage.InscriptionPage
import uqac.dim.tryhardstart.ui.screens.loginPage.LoginPage
import uqac.dim.tryhardstart.ui.screens.trajet.Trajet
import uqac.dim.tryhardstart.ui.theme.TryHardStartTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TryHardStartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar()
                        }
                    ) {
                        //Place()
                        //Trajet()
                        InscriptionPage()
                        //Recherche()
                    }
                    //StartPage()
                    //LoginPage()
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
    TryHardStartTheme {
        StartPage()
    }
}