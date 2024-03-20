package uqac.dim.tryhardstart.inscriptionPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.aptos
import uqac.dim.tryhardstart.ui.theme.poppins

@Composable
fun EnteteInscription(){
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                modifier = Modifier.padding(top = 10.dp),
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null)
            Image(
                modifier = Modifier
                    .height(125.dp)
                    .fillMaxWidth()
                ,
                painter = painterResource(id = R.drawable.rafik) ,
                contentDescription =null )

        }
        Column {
            Text(
                text = "Inscrption",
                fontFamily = aptos,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)
            Text(text = "Entrez Vos Informations Svp", fontFamily = poppins)
        }

    }

}