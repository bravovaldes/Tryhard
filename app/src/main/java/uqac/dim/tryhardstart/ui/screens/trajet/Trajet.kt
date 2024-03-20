package uqac.dim.tryhardstart.ui.screens.trajet

import android.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.ui.screens.recherche.Date
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.alatsi
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.monsterart
import uqac.dim.tryhardstart.ui.theme.poppins
import uqac.dim.tryhardstart.ui.theme.roboto

@Composable
fun Trajet(){
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Entete()
    Column {
        Box() {
            Cadre()
            CadreFinal()

        }
        Box() {
            Cadre()
            CadreFinal()

        }
        Box() {
            Cadre()
            CadreFinal()

        }
    }
    }
}