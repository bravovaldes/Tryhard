package uqac.dim.tryhardstart.ui.screens.ticket

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.monsterart
import uqac.dim.tryhardstart.ui.theme.poppins

@Composable
fun Details(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp, horizontal = 30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription =null )
            Image(modifier = Modifier
                .size(30.dp)
                .clip(shape = CircleShape), painter = painterResource(id = R.drawable.logobravo), contentDescription = null)
        }
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(vertical = 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Orange)
                    .height(55.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    , text = "418-490-XXXX",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center)
            }
            Column(
                modifier = Modifier.padding(horizontal = 25.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "11:30", fontWeight = FontWeight.Bold)
                    Text(text = "16:30", fontWeight = FontWeight.Bold)
                }
                ProgressBar()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Depart", fontFamily = poppins)
                    Text(text = "Arrive", fontFamily = poppins)
                }
                Row (
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column {
                        Text(text = "Date:", fontWeight = FontWeight.Bold, color = Color.Black.copy(0.4f))
                        Text(text = "12 Oct 2024", fontFamily = poppins, fontWeight = FontWeight.Bold)
                    }
                    Card(
                        modifier = Modifier.height(40.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Orange,
                            contentColor = Color.White
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Place: A2", modifier = Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

                        }
                    }
                }
                Passager()
                Image(painter = painterResource(id = R.drawable.img_1), modifier = Modifier.fillMaxWidth(), contentDescription =null )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_save_alt_24), contentDescription = null)
                    Icon(painter = painterResource(id = R.drawable.baseline_info_outline_24), contentDescription = null)
                }
            }


        }
    }

}