package uqac.dim.tryhardstart.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel(){
    //Etats pour les champs de texte
    var username = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")


    //Etats pour les messages d'erreur

    var usernameError = mutableStateOf<String?>(null)
    var emailError = mutableStateOf<String?>(null)
    var passwordError = mutableStateOf<String?>(null)
    var confirmPasswordError = mutableStateOf<String?>(null)

    fun validateUsername() {
        usernameError.value = if (username.value.length < 3) " Doit contenir au moins 3 caractères." else null
    }

    fun validatePassword(){
        passwordError.value =
            if (password.value.length < 7)
                "Doit contenir au moins 7 caractères."
            else if (!(password.value.contains('@')||password.value.contains('$')||password.value.contains('&')))
                "Doit contenir au moins un carractere special : @,$,&"
            else
                ""
    }
    fun confirmPassword(){
        confirmPasswordError.value =
            if (password.value != confirmPassword.value)
                "les deux mots de passe ne correspondent pas"
            else
                ""
    }


}