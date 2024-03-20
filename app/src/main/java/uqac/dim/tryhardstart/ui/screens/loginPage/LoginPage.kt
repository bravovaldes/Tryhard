package uqac.dim.tryhardstart.ui.screens.loginPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.R

@Composable
fun LoginPage(){
   Column {
       Image(
           modifier = Modifier.fillMaxWidth().height(200.dp),
           painter = painterResource(id = R.drawable.loginpage) ,
           contentDescription = null )
       Forms()
   }
}