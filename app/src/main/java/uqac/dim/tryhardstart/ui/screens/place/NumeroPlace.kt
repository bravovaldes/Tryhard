package uqac.dim.tryhardstart.ui.screens.place

import android.content.ClipData.Item
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.ui.theme.Green
import uqac.dim.tryhardstart.ui.theme.Orange

@Composable
fun NumeroPlace(){
    val items1 = listOf(
        "A1", "A2",
        "B1", "B2",
        "C1", "C2",
        "D1", "D2",
        "E1", "E2",
        "F1", "F2",
        "G1", "G2",
        "H1", "H2",
        "I1", "I2",
        "F1", "F2",
        "G1", "G2",
        "H1", "H2",
        "I1", "I2",

    )
    val items2 = listOf(
        "A3", "A4",
        "B3", "B4",
        "C3","C4",
        "D3", "D4",
        "E3", "E4",
        "F3", "F4",
        "G3", "G4",
        "H3", "H4",
        "I3", "I4"
    )
    Row(
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues( bottom = (100).dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .width(130.dp)
                .offset((-20).dp)
        ){
            items(items1){
                item ->
                Card(
                    backgroundColor = if(item=="A1") Orange else if(item=="D2") Green else if(item=="B2") Green else Color.White,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = item, textAlign = TextAlign.Center)
                    }
                }
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues( bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .width(130.dp)
                .offset((20).dp)
        ){
            items(items2){
                item ->
                Card(
                    backgroundColor = if(item=="B4") Green else if(item=="C3") Orange else Color.White,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        Text(text = item, textAlign = TextAlign.Center)
                    }
                }

            }
        }
    }

}