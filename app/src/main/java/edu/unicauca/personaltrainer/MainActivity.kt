package edu.unicauca.personaltrainer


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import edu.unicauca.personaltrainer.HomeExercise.routineExercisesBasic

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


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
                    val navController = rememberNavController()
                    val navigateAction = remember(navController){
                        NavegationActions(navController)
                    }
                    val navBackStackEnry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEnry?.destination?.route?:AppRoute.Routine

                    AppContent(navController = navController,
                        selectedDestination = selectedDestination,
                        navigate = navigateAction::navigateTo)
                }
            }
        }
    }
}






/*********** Pagina de inicio de la aplicacion **********/
@Composable
fun OpenPage(modifier: Modifier = Modifier){
    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        PersonalTrainerTheme {

            Column(modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    painter = painterResource(R.drawable.logopersonaltrainer),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.Title_Register),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "Bienvenido a YOUR PERSONAL TRAINER",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "La mejor aplicacion para tus entrenamientos",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Column (modifier = modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.Blue)

                        ) {
                            Text(text = "Iniciar Sesion")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Crear cuenta")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.LightGray)
                        ) {
                            Text(text = "Continuar como anonimo", color = Color.Blue)
                        }
                    }
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


/*********** Fin de Formulario de registro **********/


/*********** Inicio pagina de principal **********/

/*********** Inicio navegación **********/

@Composable
fun MyAppBottomNavigation(
    selectedDestination: String,
    navigate: (NavItem)->Unit
)
{
    NavigationBar (modifier = Modifier.fillMaxWidth()){
        Nav_Items.forEach{ destination ->
            NavigationBarItem(selected = selectedDestination == destination.route ,
                onClick = { navigate(destination) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.selectedIcon),
                        contentDescription = stringResource(id = destination.iconTextId)
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
    navigate:(NavItem)->Unit
)
{
    Row(modifier = modifier.fillMaxSize())
    {
        Column(modifier = modifier.fillMaxSize()) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = AppRoute.Routine){
                composable(AppRoute.Routine){

                }
                composable(AppRoute.Personalize){

                }
                composable(AppRoute.Exercises){

                }
                composable(AppRoute.Records){

                }
                composable(AppRoute.Me){

                }
            }
            MyAppBottomNavigation(
                selectedDestination = selectedDestination,
                navigate = navigate)
        }
    }
}
/*********** Inicio pagina de rutinas **********/
fun OpenPagePreview(){
    PersonalTrainerTheme {
        OpenPage()
    }
}


@Composable
fun SignIn(modifier: Modifier = Modifier){
    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        PersonalTrainerTheme {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    painter = painterResource(R.drawable.logopersonaltrainer),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(8.dp)
                )

                Text(
                    text = stringResource(id = R.string.Title_Register),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "Bienvenido a YOUR PERSONAL TRAINER",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "La mejor aplicacion para tus entrenamientos",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                // Campo de texto para el username
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(text = "Usuario: ")
                    TextField(
                        value = "Usuario",
                        onValueChange = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Campo de texto para la contraseña
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(text = "Contraseña: ")
                    TextField(
                        value = "Contraseña",
                        onValueChange = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Botón de inicio de sesión
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Iniciar Sesion")
                }

                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    PersonalTrainerTheme {
        SignIn()
    }
}


