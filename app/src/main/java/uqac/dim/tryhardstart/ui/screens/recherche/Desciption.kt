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
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.arial
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.viewmodel.BusinessAccountViewModel
import uqac.dim.tryhardstart.viewmodel.RechercheViewModel

@Composable
fun Desciption(businessAccountViewModel: BusinessAccountViewModel,rechercheViewModel: RechercheViewModel){

    Column {
        Text(text = "Bonjour, "+rechercheViewModel.nomReservateur.value, color = Color.White, fontFamily = arial)

        Text(
            text =if ((businessAccountViewModel.modeUser.value)) "Reservez Votre Ticket" else "Démarrer l'exploitation d'un bus",
            color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold, fontFamily = amaranth)
    }
}