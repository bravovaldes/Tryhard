package uqac.dim.tryhardstart.ui.screens.recherche

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.alatsi
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.viewmodel.BusinessAccountViewModel

@Composable
fun Date(businessAccountViewModel: BusinessAccountViewModel){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier.size(if (businessAccountViewModel.modeUser.value)60.dp else 50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Green.copy(0.13f)
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_date_range_24),
                    contentDescription =null ,
                    tint = Green
                )
            }

        }
        Column {
            Text(text = "DEPART", fontWeight = FontWeight.Bold, color = Color.LightGray)
            Text(text = "Jeu 11 Mars 2024 ", fontFamily = poppins, fontWeight = FontWeight.Bold, fontSize = 17.sp,)
        }

    }
}