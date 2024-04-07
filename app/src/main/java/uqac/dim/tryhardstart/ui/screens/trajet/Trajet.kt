package uqac.dim.tryhardstart.ui.screens.trajet

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import uqac.dim.tryhardstart.viewmodel.AdminViewModel
import uqac.dim.tryhardstart.viewmodel.RechercheViewModel

@Composable
fun Trajet(rechercheViewModel: RechercheViewModel,navController: NavController,adminViewModel: AdminViewModel){
    LaunchedEffect(Unit){
        rechercheViewModel.rechercherTrajets()
    }
    val trajets by rechercheViewModel.trajets.collectAsState()
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Entete(rechercheViewModel,trajets)
    LazyColumn {
       items(trajets){trajet->
           Box {
//               rechercheViewModel.currentBusId.value = trajet.idBus
//               adminViewModel.currentBusId.value = trajet.idBus
               Cadre(trajet,rechercheViewModel, adminViewModel)
               CadreFinal(trajet,navController,rechercheViewModel,adminViewModel)
           }
           Log.d("idBu",trajet.idBus)
           Log.d("matri",adminViewModel.matricule.value)

       }
    }
    }
}