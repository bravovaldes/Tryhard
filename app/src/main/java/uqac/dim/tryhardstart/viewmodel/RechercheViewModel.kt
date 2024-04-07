package uqac.dim.tryhardstart.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
data class Trajet(
    val villeDepart: String,
    val villeArrive: String,
    val dateDepart: String,
    val heureDepart: String,
    val heureArrivee: String,
    val prix: String,
    val promotion: Boolean,
    val idBus:String,
)
data class Seat(
    var numeroChaise: String ="",
    var reserved: Boolean = false
)
data class Seat1(
    var numeroChaise: String ="",
    var reserved: Boolean = false
)

class RechercheViewModel():ViewModel(){
    var numeroChaise = mutableStateOf("")
    var numeroChaise1 = mutableStateOf("")
    val _trajets = MutableStateFlow<List<Trajet>>(emptyList())
    val trajets = _trajets.asStateFlow()
    private val _villeDepart = mutableStateOf("")
    private val _villeArrivee = mutableStateOf("")
    var dateDepart = mutableStateOf("")
    val textValidError = mutableStateOf("")
    var seats = mutableStateListOf<Seat>()
    var seats1 = mutableStateListOf<Seat1>()
    val villeDepart = _villeDepart
    val villeArrivee = _villeArrivee
    var currentBusId = mutableStateOf("")
    var villeDepartTrajet = mutableStateOf("")
    var villeArriveTrajet = mutableStateOf("")
    var dateTrajet = mutableStateOf("")
    var heureDebutTrajet = mutableStateOf("")
    var matriculeTrajet = mutableStateOf("")
    var heureFinTrajet = mutableStateOf("")
    var promotionTrajet = mutableStateOf<Boolean>(false)
    var prixTrajet = mutableStateOf("")
    fun setVilleDepart(value:String){
        _villeDepart.value = value
    }

    fun setVilleArrivee(value: String){
        _villeArrivee.value = value
    }

    fun isAdresseValid(): Boolean {
        val isValid = _villeDepart.value != _villeArrivee.value
        textValidError.value = if (!isValid) "Les deux villes doivent être différentes." else ""
        return isValid
    }
    val currentTime = Timestamp.now()

    fun rechercherTrajets() {
        val db = FirebaseFirestore.getInstance()
        db.collection("reservations")
            .whereEqualTo("villeDepart", _villeDepart.value)
            .whereEqualTo("villeArrive", _villeArrivee.value)
            //.whereGreaterThan("heureDepart",currentTime)
            //.whereEqualTo("dateDepart", dateDepart.value)
            .orderBy("heureDepart")
            .get()
            .addOnSuccessListener { documents ->
                _trajets.value = documents.map { document ->
                    Trajet(
                        villeDepart = document.getString("villeDepart") ?: "",
                        villeArrive = document.getString("villeArrive") ?: "",
                        dateDepart = document.getString("dateDepart") ?: "",
                        heureDepart = document.getString("heureDepart") ?: "",
                        heureArrivee = document.getString("heureArrive") ?: "",
                        prix = document.getString("prix") ?: "",
                        promotion = document.getBoolean("promotion") ?: false,
                        idBus = document.getString("matricule")?:"",
                    )
                }
            }

    }

    //recuperation des sieges des l'initialisation du composable

    fun initSeat(){
        val db = FirebaseFirestore.getInstance()
        db.collection("bus").document(currentBusId.value).collection("seats").get()
            .addOnSuccessListener {
                documents->
                seats.clear()
                documents.forEach {
                    document->
                    val seat = document.toObject(Seat::class.java)
                    seats.add(seat)
                }
            }
    }
    fun initSeatGauche(){
        val db = FirebaseFirestore.getInstance()
        db.collection("bus").document(currentBusId.value).collection("seats1").get()
            .addOnSuccessListener {

                    documents->
                seats1.clear()

                documents.forEach {
                        document->
                    val seat = document.toObject(Seat1::class.java)
                    seats1.add(seat)
                }
            }
    }

    fun updateSeatStatus() {
        if (numeroChaise.value.isNotEmpty()){
            val db = FirebaseFirestore.getInstance()
            db.collection("bus").document(currentBusId.value)
                .collection("seats").document(numeroChaise.value)
                .update("reserved", true) // 'reserved' est maintenant un champ booléen
                .addOnSuccessListener {
                    // Mettre à jour l'interface utilisateur en fonction du nouvel état de la réservation
                }
                .addOnFailureListener { e ->
                    // Gérer l'erreur
                }
        }

    }
    fun updateSeatStatusGauche() {
        if (numeroChaise1.value.isNotEmpty()){
            Log.d("num1",numeroChaise1.value)

            val db = FirebaseFirestore.getInstance()
            db.collection("bus").document(currentBusId.value)
                .collection("seats1").document(numeroChaise1.value)
                .update("reserved", true) // 'reserved' est maintenant un champ booléen
                .addOnSuccessListener {
                    // Mettre à jour l'interface utilisateur en fonction du nouvel état de la réservation
                }
                .addOnFailureListener { e ->
                    // Gérer l'erreur
                }

        }

    }













}