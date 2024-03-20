package uqac.dim.tryhardstart.ui.screens.bottomNavigation

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import uqac.dim.tryhardstart.R

sealed class Screen(val route: String, @DrawableRes val icon: Int, val title: String) {
    data object Home : Screen("Accueil", R.drawable.baseline_home_24, "Accueil")
    data object Trajet : Screen("Trajet", R.drawable.baseline_swap_calls_24, "Trajet")
    data object Ticket: Screen("Ticket",R.drawable.baseline_book_online_24,"Ticket")
    data object Profile : Screen("User", R.drawable.baseline_person_24, "User")

}
