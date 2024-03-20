package uqac.dim.tryhardstart.ui.screens.recherche

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.ui.theme.poppins

@Composable
fun Desciption(){

    Column {
        Text(text = "Bonjour Bravo,", color = Color.White)
        Text(text = "Reservez Votre Ticket", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = poppins)
    }
}