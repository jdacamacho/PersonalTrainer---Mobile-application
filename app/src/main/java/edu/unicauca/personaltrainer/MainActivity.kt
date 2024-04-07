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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

import edu.unicauca.personaltrainer.HomeExercise.routineExercisesBasic

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
                    routineExercisesBasic();
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
