package uqac.dim.tryhardstart.ui.screens.recherche

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recherche(){

    Column(
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.30f)
                .background(Green, RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxHeight(0.6f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Entete()
                Desciption()
            }
        }
        Column {
            Box {
                Column(
                    modifier = Modifier
                        .offset(y = (-45).dp)
                ) {
                    From()
                    Spacer(modifier = Modifier.height(15.dp))
                    To()

                }
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 45.dp, top = 30.dp)
                        .size(40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Orange.copy(0.7f)
                    )

                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_swap_calls_24),
                            contentDescription =null, tint = Color.White )
                    }

                }


            }
            Column(
                modifier = Modifier.padding(20.dp).offset(y= (-45).dp)
            ) {
                Personnalisation()

            }

        }

    }


}