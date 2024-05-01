package edu.unicauca.personaltrainer


import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

data class NavItem(
    val route:String,
    val selectedIcon: Int,
    val iconTextId: Int
    )

val Nav_Items = listOf(
    NavItem(
        route = AppRoute.Routine,
        selectedIcon = R.drawable.pesa,
        iconTextId = R.string.nav_rutines
    ),
    NavItem(
        route = AppRoute.Personalize,
        selectedIcon = R.drawable.lapiz,
        iconTextId = R.string.nav_personalitation
    ),
    NavItem(
        route = AppRoute.Exercises,
        selectedIcon = R.drawable.levantamiento_de_pesas,
        iconTextId = R.string.nav_exercises
    ),
    NavItem(
        route = AppRoute.Records,
        selectedIcon = R.drawable.medalla,
        iconTextId = R.string.nav_records
    ),
    NavItem(
        route = AppRoute.Me,
        selectedIcon = R.drawable.usuario,
        iconTextId = R.string.nav_me
    ),
)

object AppRoute{
    const val Routine = "Routine"
    const val Personalize = "Personalize"
    const val Exercises = "Exercises"
    const val Records = "Records"
    const val Me = "Me"
    const val ExercisesRoutine = "ExercisesRoutine"
}

class NavegationActions(
    private val navController: NavController
)
{
    fun navigateTo(destination: NavItem){
        navController.navigate(destination.route){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    }
}