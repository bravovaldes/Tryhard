package uqac.dim.tryhardstart.ui.screens.inscriptionPage

import android.util.Log
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
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.TextFieldDefaults

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
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
//    val myCustomColors = TextFieldDefaults.colors(
//        //textColor = Color.Black, // Couleur du texte
//        disabledTextColor = Color.Gray, // Couleur du texte lorsque le champ est désactivé
//        cursorColor = Color.Blue, // Couleur du curseur
//        //leadingIconColor = Color.DarkGray, // Couleur de l'icône de début
//        //trailingIconColor = Color.DarkGray, // Couleur de l'icône de fin
////        focusedBorderColor = Color.Green, // Couleur de la bordure lorsqu'elle est focalisée
////        unfocusedBorderColor = Color.Red, // Couleur de la bordure lorsqu'elle n'est pas focalisée
////        disabledBorderColor = Color.Gray, // Couleur de la bordure lorsqu'elle est désactivée
//        // et autres paramètres selon vos besoins
//    )

    var phoneNumber: String by remember { mutableStateOf("") }
    var phone: String by remember { mutableStateOf("") }
    var fullPhoneNumber: String by remember { mutableStateOf("") }
    var isNumberValid: Boolean by remember { mutableStateOf(false) }
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
                shape = RoundedCornerShape(23.dp),

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
        val focusManager = LocalFocusManager.current

        Column {

            val focusRequester = FocusRequester()

            TogiCountryCodePicker(
                showError = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp)
                    .focusRequester(focusRequester),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    //textColor = Green,
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Green
                ) ,

                label = { Text("Phone Number") },
                onValueChange = { (code, phone), isValid ->
                    //Log.d("CCP", "onValueChange: $code $phone -> $isValid")

                    phoneNumber = phone
                    fullPhoneNumber = code + phone
                    isNumberValid = isValid
                },

            )
            if (phone.isNotEmpty()){
                Text(text = phone)
            }

            LaunchedEffect(Unit) {
                focusManager.clearFocus()
            }
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
                shape = RoundedCornerShape(23.dp),

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
                shape = RoundedCornerShape(23.dp),

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
            shape = RoundedCornerShape(23.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green
            ),
            onClick = {
                phone = if (isNumberValid){
                    "Numero valide"
                } else{
                    "numero invalid"
                }
                //signupViewModel.signUser()
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