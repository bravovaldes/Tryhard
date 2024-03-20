package uqac.dim.tryhardstart.ui.screens.inscriptionPage

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
import androidx.compose.foundation.layout.offset
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
import androidx.lifecycle.viewmodel.compose.viewModel
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.NoirClair
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.Swipe
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.ui.theme.roboto
import uqac.dim.tryhardstart.viewmodel.SignupViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulaire(signupViewModel: SignupViewModel= viewModel()){
    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 15.dp),
    ){
        Column {
            Row(
                modifier = Modifier.offset(y=5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(

                    color = Green,
                    text = "Nom d'utilisateur",
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold)
                Text(
                    text =signupViewModel.usernameError.value?:"",
                    color = Color.Red,
                    fontSize = 9.sp
                )
            }

            OutlinedTextField(
                leadingIcon = {
                              Icon(
                                  painter = painterResource(id = R.drawable.baseline_person_24) ,
                                  contentDescription = null)
                },
                label = {
                    Text(text = "Entrer Votre nom",fontFamily = poppins)
                },
                modifier = Modifier
                    .fillMaxWidth()
                ,
                shape = RoundedCornerShape(8.dp),

                value =signupViewModel.username.value ,
                onValueChange ={
                               signupViewModel.username.value = it
                               signupViewModel.validateUsername()
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black
                )

            )
        }
        Column {
            Row {
                Text(
                    color = Green,
                    text = "Email",
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold)
                Text(
                    text =signupViewModel.emailError.value?:"",
                    color = Color.Red,
                    fontSize = 9.sp
                )
            }

            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_email_24) ,
                        contentDescription = null)
                },
                label = {
                    Text(text = "Entrer Votre Email",fontFamily = poppins)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),

                value =signupViewModel.email.value ,
                onValueChange ={
                               signupViewModel.email.value = it
                               signupViewModel.validateEmail()
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black

                )

            )
        }
        Column {
            Row(
                modifier = Modifier.offset(y=5.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    color = Green,
                    text = "Mot de passe",
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold)
                Text(
                    text =signupViewModel.passwordError.value?:"",
                    color = Color.Red,
                    fontSize = 8.sp
                )

            }

            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_24) ,
                        contentDescription = null)
                },
               // isError = ,
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_off_24) ,
                        contentDescription = null)
                },
                label = {
                    Text(text = "Entrer Votre mot de passe",fontFamily = poppins)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),

                value =signupViewModel.password.value ,
                onValueChange ={
                               signupViewModel.password.value = it
                               signupViewModel.validatePassword()
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black

                )

            )
        }
        Column {
            Row(
                modifier = Modifier.offset(y=5.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Confimer Mot de passe",
                    color = Green, fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold)
                Text(
                    text = signupViewModel.confirmPasswordError.value?:"",
                    color = Color.Red,
                    fontSize = 11.sp
                    )
            }

            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_lock_24) ,
                        contentDescription = null)
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_off_24) ,
                        contentDescription = null)
                },
                label = {
                    Text(text = "Confimer le mot de passe",fontFamily = poppins)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),

                value =signupViewModel.confirmPassword.value,
                onValueChange ={
                               signupViewModel.confirmPassword.value = it
                               signupViewModel.confirmPassword()
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black

                )

            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "S'incrire",fontFamily = poppins)
        }
        
    }
}