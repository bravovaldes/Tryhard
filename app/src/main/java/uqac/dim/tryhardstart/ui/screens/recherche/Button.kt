package uqac.dim.tryhardstart.ui.screens.recherche

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.ui.theme.Orange

@Composable

fun ButtonSearch(){
   Button(onClick = { /*TODO*/ },
       colors = ButtonDefaults.buttonColors(
           containerColor = Orange
       ),
       shape = RoundedCornerShape(9.dp),
       modifier = Modifier.fillMaxWidth().padding(end = 5.dp)
       ) {
       Text(
           modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
           text = "Rechercher",
           fontWeight = FontWeight.Bold,)
   }
}