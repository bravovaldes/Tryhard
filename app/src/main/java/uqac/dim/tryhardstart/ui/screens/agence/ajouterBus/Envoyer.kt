package uqac.dim.tryhardstart.ui.screens.agence.ajouterBus

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.ui.screens.recherche.Date
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.viewmodel.AdminViewModel
import uqac.dim.tryhardstart.viewmodel.BusinessAccountViewModel
import uqac.dim.tryhardstart.viewmodel.RechercheViewModel


@Composable
fun Envoyer(businessAccountViewModel: BusinessAccountViewModel,adminViewModel: AdminViewModel,rechercheViewModel: RechercheViewModel){
    Card(
        modifier = Modifier
            //.height(405.dp)
            //.padding(bottom = 0.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
    ) {

        Column (
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 10.dp, start = 5.dp, bottom = 0.dp)
            ,
           // horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy( if(businessAccountViewModel.modeUser.value)20.dp else 8.dp)
        ){
            Passenger(adminViewModel)
            Date(businessAccountViewModel,adminViewModel, rechercheViewModel )
            HeureDepart(adminViewModel)
            HeureArrive(adminViewModel)
            Matricule(adminViewModel)
            Formulaire(adminViewModel)
            Button(
                onClick = {
                          adminViewModel.saveDataToFirestore()
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Green
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 3.dp)) {
                    Text(text = "Enregistrer")
            }

            

        }
    }

}