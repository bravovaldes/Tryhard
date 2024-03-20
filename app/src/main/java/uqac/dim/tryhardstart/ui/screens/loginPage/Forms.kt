package uqac.dim.tryhardstart.ui.screens.loginPage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.NoirClair
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.Swipe
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.ui.theme.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Forms(){
    val inscription = buildAnnotatedString {
        withStyle(style = SpanStyle(color = NoirClair)) {
            append("Vous N'avez pas de Compte?")
        }
        withStyle(
            style = SpanStyle(
                color = Orange,
                fontFamily = amaranth,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            ),
        ) {
            append("S'incrire")
        }
    }
    Column(
        modifier = Modifier.padding(13.dp)
    ) {
        Text(
            text = "Connexion",
            fontFamily = poppins,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                          Icon(
                              painter = painterResource(id = R.drawable.baseline_email_24) ,
                              contentDescription = null)
            },

            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFC6D2EE),
                unfocusedBorderColor = Color(0xFFEDF0F7),
            ),
            value = "",
            onValueChange = {

            },
            label = {
                Text(text = "Email", fontWeight = FontWeight.Bold)
            }
            )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_lock_24),
                    contentDescription = null)
            },
            trailingIcon = {
                           Icon(
                               painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                               contentDescription =null )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFC6D2EE),
                unfocusedBorderColor = Color(0xFFEDF0F7),
            ),
            value = "",
            onValueChange = {

            },
            label = {
                Text(text = "Mot de passe",fontWeight = FontWeight.Bold)
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Connexion", fontWeight = FontWeight.Bold, fontFamily = poppins)
            
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Mot de passe oublié ?",
            color = Orange,
            fontFamily = amaranth,
            textAlign = TextAlign.End
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
        ){

            Spacer(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(2.dp)
                    .background(Color.LightGray)
            )
            Text(text = "OR", color = NoirClair, modifier = Modifier.padding(start = 2.dp, end = 2.dp), fontWeight = FontWeight.ExtraBold)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.LightGray)
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(50.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange.copy(0.1f),
                    contentColor = Color.Black,
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(27.dp),
                        painter = painterResource(id = R.drawable.googl) ,
                        contentDescription =null )
                    Text(
                        modifier = Modifier,
                        text = "Se Connecter avec Google",
                        fontFamily = poppins
                    )
                }


            }
            Button( modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange.copy(0.1f),
                    contentColor = Color.Black,
                ),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Black),
                onClick = { /*TODO*/ }){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(27.dp)
                        ,
                        painter = painterResource(id = R.drawable.facebook_logo) ,
                        contentDescription = null)
                    Text(
                       // modifier = Modifier.fillMaxWidth(),
                        text = "Se Connecter avec Facebook",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontFamily = poppins
                    )
                }

            }
        }
        Text(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), textAlign = TextAlign.Center, text = inscription)
    }

}