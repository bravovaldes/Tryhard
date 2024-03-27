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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.zIndex
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.screens.agence.ajouterBus.Envoyer
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.viewmodel.BusinessAccountViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recherche(businessAccountViewModel: BusinessAccountViewModel){
  LaunchedEffect(Unit){
      businessAccountViewModel.verificationSuccess()
  }
    LazyColumn(
        modifier = Modifier.fillMaxSize(1f)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if (businessAccountViewModel.modeUser.value) 200.dp else 200.dp)
                    .background(Green, RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp
                        )
                        .fillMaxHeight(0.6f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Entete()
                    Desciption(businessAccountViewModel)
                }
            }
            Column (
                modifier = Modifier.fillMaxSize()

            ){
                Box(
                ) {
                    Column(
                        modifier = Modifier
                            .zIndex(0f)
                            //.fillMaxSize()
                            .offset(y = if (businessAccountViewModel.modeUser.value) (-45).dp else (-83).dp)
                    ) {
                        From(businessAccountViewModel)
                        Spacer(modifier = Modifier.height(5.dp))
                        To(businessAccountViewModel)

                    }
                    Card(
                        modifier = Modifier
                            .zIndex(12f)
                            .align(Alignment.TopEnd)
                            .padding(
                                end = 45.dp,
                                top = if (businessAccountViewModel.modeUser.value) 30.dp else 0.dp
                            )
                            .offset(y = if (businessAccountViewModel.modeUser.value) 0.dp else (-14).dp)
                            .size(40.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Orange.copy(0.7f)
                        )

                    ) {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .zIndex(4f), contentAlignment = Alignment.Center){
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_swap_calls_24),
                                contentDescription =null, tint = Color.White )
                        }

                    }


                }
                Column(
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp,
                            vertical = if (businessAccountViewModel.modeUser.value) 20.dp else 0.dp
                        )
                        .offset(y = if (businessAccountViewModel.modeUser.value) (-45).dp else (-80).dp)
                ) {
                    if ((businessAccountViewModel.modeUser.value)){
                        Personnalisation(businessAccountViewModel)
                    }
                    else{
                        Envoyer(businessAccountViewModel)
                    }

                }

            }
        }
    }


}