package uqac.dim.tryhardstart.viewmodel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import uqac.dim.tryhardstart.model.UserRepository

class SignupViewModel() : ViewModel(){
    //Etats pour les champs de texte
    var username = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")

    var signupStatusMessage = MutableStateFlow("")
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
                "ne correspondent pas"
            else
                ""
    }

    fun validateEmail(){
        emailError.value = if(!(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()))
                   "Votre Email est invalide"

                else
                    ""
    }

    private fun allFields() = usernameError.value== null && emailError.value==null &&
                      passwordError.value== null && confirmPasswordError.value == null


    fun signUser() = viewModelScope.launch {
        if (allFields()) {
            signupStatusMessage.value = "Veuillez corriger les erreurs avant de soumettre."
            return@launch
        }

        signupStatusMessage.value = "Chargement..."
        try {
            val result = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.value, password.value).await()
            // Vérifiez ici si vous avez besoin de faire plus avec result, par exemple stocker des infos utilisateur supplémentaires dans Firestore
            signupStatusMessage.value = "Inscription réussie!"
        } catch (e: Exception) {
            signupStatusMessage.value = "Échec de l'inscription. Veuillez réessayer. ${e.message}"
        }
    }

}