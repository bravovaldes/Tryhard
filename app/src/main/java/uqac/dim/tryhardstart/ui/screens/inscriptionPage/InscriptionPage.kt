package uqac.dim.tryhardstart.ui.screens.inscriptionPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.inscriptionPage.EnteteInscription

@Composable
fun InscriptionPage(){
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        EnteteInscription()
        Formulaire()
    }
}