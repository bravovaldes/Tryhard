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
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.togitech.ccp.component.TogiCountryCodePicker
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
    val signupStatusMessage by signupViewModel.signupStatusMessage.collectAsState()
    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 15.dp),
    ){
        Column {
            if (signupStatusMessage.isNotEmpty()) {
                Text(text = signupStatusMessage)
            }
            Row(
                modifier = Modifier.offset(y=5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

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
                    text =signupViewModel.emailError.value?:"",
                    color = Color.Red,
                    fontSize = 9.sp
                )
            }

            TogiCountryCodePicker(
                modifier = Modifier.width(
                    400.dp
                ),
                text = signupViewModel.email.value,
                onValueChange = { signupViewModel.email.value = it },
                shape = RoundedCornerShape(10.dp)
            )
        }
        Column {
            Row(
                modifier = Modifier.offset(y=5.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                verticalAlignment = Alignment.CenterVertically
            ){

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
                containerColor = Green
            ),
            onClick = {
                signupViewModel.signUser()
            }
        ) {
            Text(text = "S'incrire",fontFamily = poppins)
        }
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
            }}
        
    }
}