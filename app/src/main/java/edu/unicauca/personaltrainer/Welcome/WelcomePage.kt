package edu.unicauca.personaltrainer.Welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.unicauca.personaltrainer.R
import edu.unicauca.personaltrainer.ui.theme.PersonalTrainerTheme
import edu.unicauca.personaltrainer.ui.theme.YellowSecondary


@Composable
fun headerForm(modifier: Modifier = Modifier){
    Spacer(modifier = Modifier.height(64.dp))
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logopersonaltrainer),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(32.dp))
        val title = stringResource(R.string.Title_Register)
        Text(
            text = "Bienvenido a $title",
            modifier = modifier.paddingFromBaseline(top = 30.dp , bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color(0xFF1D4EA5)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.Slogan_register),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun OpenPage(navController: NavController, modifier: Modifier = Modifier){
    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        PersonalTrainerTheme {

            Column(modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                            onClick = { navController.navigate("iniciar sesion") },
                            colors = ButtonDefaults.buttonColors(Color.Blue),
                            modifier = Modifier.size(250.dp, 50.dp) // Establece el tamaño del botón
                        ) {
                            Text(text = "Iniciar Sesion")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { navController.navigate("crear cuenta") },
                            colors = ButtonDefaults.buttonColors(YellowSecondary),
                            modifier = Modifier.size(250.dp, 50.dp) // Establece el tamaño del botón
                        ) {
                            Text(text = "Crear cuenta")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { navController.navigate("continuar como anonimo") },
                            colors = ButtonDefaults.buttonColors(Color.LightGray),
                            modifier = Modifier.size(250.dp, 50.dp) // Establece el tamaño del botón
                        ) {
                            Text(text = "Continuar como anonimo", color = Color.Blue)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun WelcomePage(navController: NavController, modifier: Modifier = Modifier){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            headerForm()
            OpenPage(navController = navController)
        }
    }
}
/*********** Inicio pagina de rutinas **********/
@Preview(showBackground = true)
@Composable
fun OpenPagePreview(){
    val navController = rememberNavController()
    PersonalTrainerTheme {
        WelcomePage(navController = navController)
    }
}