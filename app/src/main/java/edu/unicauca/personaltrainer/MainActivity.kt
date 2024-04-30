package edu.unicauca.personaltrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.unicauca.personaltrainer.Auth.form
import edu.unicauca.personaltrainer.HomeExercise.routineExercisesBasic
import edu.unicauca.personaltrainer.Personalized.Personalize
import edu.unicauca.personaltrainer.Personalized.Routine
import edu.unicauca.personaltrainer.Personalized.SampleRoutines
import edu.unicauca.personaltrainer.exercises.ExerciseList
import edu.unicauca.personaltrainer.exercises.ExercisesComplete
import edu.unicauca.personaltrainer.ui.theme.BlueMain


import edu.unicauca.personaltrainer.ui.theme.PersonalTrainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalTrainerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentUser:CurrentUser by viewModels()

                    val navController = rememberNavController()
                    val navigateAction = remember(navController){
                        NavegationActions(navController)
                    }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEntry?.destination?.route?:AppRoute.Routine

                    AppContent(navController = navController,
                        selectedDestination = selectedDestination,
                        navigate = navigateAction::navigateTo,
                        user = currentUser)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewForm(){
    form();
}

/*********** Inicio navegación **********/

@Composable
fun MyAppBottomNavigation(
    selectedDestination: String,
    navigate: (NavItem)->Unit
)
{
    NavigationBar(
        containerColor = BlueMain,
        contentColor = Color.Black
    ){
        Nav_Items.forEach{ destination ->
            NavigationBarItem(selected = selectedDestination == destination.route ,
                onClick = { navigate(destination) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.selectedIcon),
                        contentDescription = stringResource(id = destination.iconTextId),
                        modifier = Modifier.size(35.dp)
                    )
                }
            )
        }
    }
}
@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination:String,
    navigate:(NavItem)->Unit,
    user:CurrentUser
)
{
    Row()
    {
        Column() {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = AppRoute.Personalize){
                composable(AppRoute.Routine){
                    routineExercisesBasic()
                }
                composable(AppRoute.Personalize)
                {
                    Personalize(navController = navController, user = user)
                }
                composable(AppRoute.Exercises){

                }
                composable(AppRoute.Records){

                }
                composable(AppRoute.Me){

                }
                composable(AppRoute.ExercisesRoutine){
                    ExercisesComplete(routine = user.routines[user.option], user = user, navController = navController)
                }
            }
            MyAppBottomNavigation(
                selectedDestination = selectedDestination,
                navigate = navigate)
        }
    }
}
/*
@Preview
@Composable
fun PreviewNavegacion(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val currentUser:CurrentUser by viewModels()
        val navController = rememberNavController()
        val navigateAction = remember(navController){
            NavegationActions(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val selectedDestination = navBackStackEntry?.destination?.route?:AppRoute.Routine

        AppContent(navController = navController,
            selectedDestination = selectedDestination,
            navigate = navigateAction::navigateTo,
            user = currentUser)
    }
}
*/





