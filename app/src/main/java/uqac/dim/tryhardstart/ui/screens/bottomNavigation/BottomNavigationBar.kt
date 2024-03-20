package uqac.dim.tryhardstart.ui.screens.bottomNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uqac.dim.tryhardstart.ui.theme.Orange
import uqac.dim.tryhardstart.ui.theme.amaranth
import uqac.dim.tryhardstart.ui.theme.poppins

@Composable
fun BottomNavigationBar(){
    val items = listOf(
        Screen.Home,
        Screen.Trajet,
        Screen.Ticket,
        Screen.Profile
    )
   BottomNavigation(
       backgroundColor = Color.White,
       elevation = 20.dp,
       contentColor = Color.Black
   ) {
       items.forEach {
           screen ->
           BottomNavigationItem(
               selectedContentColor = Orange,
               unselectedContentColor = Color.Black.copy(0.4f),
               selected = screen.title=="Accueil" ,
               onClick = {  },
               label = { Text(text = screen.title, fontFamily = amaranth, fontWeight = FontWeight.Bold)},
               icon = {
                   Box(contentAlignment = Alignment.TopCenter){
                       if(screen.title=="Accueil"){
                           Box(modifier = Modifier.fillMaxWidth(0.9f).height(2.dp).background(Orange))
                       }
                       Icon(painter = painterResource(id = screen.icon), contentDescription = null, modifier = Modifier.padding(top = 6.dp))
                   }
                   })
       }

   }


}