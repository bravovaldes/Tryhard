package uqac.dim.tryhardstart.ui.screens.recherche

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrerror.singleRowCalendar.SingleRowCalendar
import uqac.dim.tryhardstart.R
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.alatsi
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.viewmodel.AdminViewModel
import uqac.dim.tryhardstart.viewmodel.BusinessAccountViewModel
import uqac.dim.tryhardstart.viewmodel.RechercheViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Date(businessAccountViewModel: BusinessAccountViewModel,adminViewModel: AdminViewModel,rechercheViewModel: RechercheViewModel){
    var show by remember { mutableStateOf(false) }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                show = true
            },
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier.size(if (businessAccountViewModel.modeUser.value)60.dp else 50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Green.copy(0.13f)
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_date_range_24),
                    contentDescription =null ,
                    tint = Green
                )
            }

        }
        fun getFourNextDays(): List<String> {
            val formatter = DateTimeFormatter.ofPattern("EEE d MMMM ", Locale.FRENCH)
            return List(3) { index ->
                LocalDate.now().plusDays(index.toLong()).format(formatter)
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.FRENCH) else it.toString() }
            }
        }
        val days = getFourNextDays() // Récupérer les jours
        var expanded by remember { mutableStateOf(false) }
        var selectedDay by remember { mutableStateOf(days[0]) } // Aujourd'hui par défaut
        adminViewModel.dateDepart.value = selectedDay
        rechercheViewModel.dateDepart.value = selectedDay
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            //val containerColor = FilledTextFieldTokens.ContainerColor.toColor()
            TextField(
                textStyle = TextStyle(fontWeight = FontWeight.Bold, fontFamily = poppins),
                readOnly = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Green,
                    unfocusedIndicatorColor = Green,
                    unfocusedContainerColor = Color.White,
                ),
                value = selectedDay,
                onValueChange = {
                                adminViewModel.dateDepart.value = selectedDay
                                rechercheViewModel.dateDepart.value = selectedDay

                },
                label = { Text("Jour de depart", color = Green, fontFamily = poppins) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor()
            )
            Log.d("datedepart",adminViewModel.dateDepart.value)
            ExposedDropdownMenu(
                modifier = Modifier.background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                days.forEach { day ->
                    DropdownMenuItem(
                        text = { Text(day, fontFamily = poppins ) },
                        onClick = {
                            selectedDay = day
                            expanded = false
                        }
                    )
                }
            }
        }


    }


    if (show) {

    }
}