package uqac.dim.tryhardstart.ui.screens.trajet

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins

@Composable
fun CadreFinal(){
    var expanded by remember {
        mutableStateOf(false)
    }
    Row {
        Column(
            modifier = Modifier
                .offset(x = 30.dp, y = 25.dp)
                .fillMaxWidth(0.60f)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "General Voyage",
                fontSize = 20.sp,
                fontFamily = amaranth,
                fontWeight = FontWeight.Bold
            )
            Column(
            ) {
                Depart()
                Row {
                    Canvas(modifier = Modifier
                        .height(30.dp)
                        .padding(start = 15.dp) ){
                        val canvasWith = size.width
                        val canvasHeight = size.height
                        val dashPathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f)
                        )
                        drawLine(
                            color = Color.Black,
                            start = Offset(0f,canvasHeight),
                            end = Offset(canvasWith,0f),
                            pathEffect = dashPathEffect
                        )

                    }
                    if (expanded){
                        Column(
                            modifier = Modifier.padding(start = 34.dp)
                        ) {
                            Text(text = "-Baffoussam ", fontSize = 8.sp, fontFamily = amaranth, fontWeight = FontWeight.Normal)
                            Text(text = "-Mbouda", fontSize = 8.sp,fontFamily = amaranth,)
                            Text(text = "+2 autres", fontSize = 8.sp,fontFamily = amaranth, color = Orange)
                        }
                    }


                }

                Arrive(onUpdate ={newvalue->
                    expanded=newvalue} )

            }
        }
        Column(
            modifier = Modifier
                .offset(x = 15.dp, y = 25.dp)
                .height(150.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "7:30 PM", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.
                buttonColors(containerColor = Orange),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Achetez", fontFamily = poppins
                )
            }
            Row {
                Text(text = "Prix:")
                Column {
                    Row(
                    ) {
                        Text( text = "5500F", textDecoration = TextDecoration.LineThrough,)
                        Text(modifier = Modifier
                            .graphicsLayer { rotationZ = -30f }
                            .offset(x = 6.dp, y = (-5).dp),text = "-25%", fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 10.sp,)
                    }
                    Text(text = "5000F", fontWeight = FontWeight.Bold, color = Color.Red)

                }

            }

        }
    }
}