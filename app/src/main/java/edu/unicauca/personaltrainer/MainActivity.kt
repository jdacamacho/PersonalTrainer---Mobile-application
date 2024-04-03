package edu.unicauca.personaltrainer


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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

/*********** Inicio de Formulario de registro **********/

@Composable
fun headerForm(modifier: Modifier = Modifier){
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
        val title = stringResource(R.string.Title_Register)
        Text(
            text = "Bienvenido a $title",
            modifier = modifier.paddingFromBaseline(top = 30.dp , bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color(0xFF1D4EA5)
        )
        Text(
            text = stringResource(R.string.Slogan_register),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun fieldForm(
    modifier: Modifier = Modifier,
    textField: String,
    textPlaceHolder: String
){
    Column(
        modifier = modifier.padding(vertical = 5.dp)
    ) {
        Text(
            text = textField,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF1D4EA5),
            modifier = Modifier.padding(end = 6.dp, start = 30.dp)
        )
        TextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .padding(start = 20.dp)
                .padding(top = 10.dp)
                .width(350.dp),
            leadingIcon = {},
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.LightGray,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder ={
                Text(text = textPlaceHolder,
                    style = MaterialTheme.typography.bodyMedium) },
            shape = RoundedCornerShape(16.dp),
        )
    }
}

@Composable
fun fieldsFromForm() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(8) { index ->
                fieldForm(
                    textField = when (index) {
                        0 -> stringResource(R.string.Name_register)
                        1 -> stringResource(R.string.LastNames_register)
                        2 -> stringResource(R.string.Age_register)
                        3 -> stringResource(R.string.Height_register)
                        4 -> stringResource(R.string.Weight_register)
                        5 -> stringResource(R.string.Email_register)
                        6 -> stringResource(R.string.UserName_register)
                        7 -> stringResource(R.string.Password_register)
                        else -> ""
                    },
                    textPlaceHolder = when (index) {
                        0 -> stringResource(R.string.Name_placeHolder)
                        1 -> stringResource(R.string.LastNames_placeHolder)
                        2 -> stringResource(R.string.Age_placeHolder)
                        3 -> stringResource(R.string.Height_placeHolder)
                        4 -> stringResource(R.string.Weight_placeHolder)
                        5 -> stringResource(R.string.Email_placeHolder)
                        6 -> stringResource(R.string.UserName_placeHolder)
                        7 -> stringResource(R.string.Password_placeHolder)
                        else -> ""
                    }

                )
            }
            item{
                registerButtomForm(onClick = {});
            }
        }
    }
}

@Composable
fun registerButtomForm(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .height(60.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Color(0xFF1D4EA5))
    ) {
        Text(text = stringResource(R.string.Buttom_Register))
    }
}

@Composable
fun form(modifier: Modifier = Modifier){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
        ){
            headerForm();
            fieldsFromForm();
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForm(){
    form();
}


/*********** Fin de Formulario de registro **********/

/*********** Inicio pagina de rutinas **********/

@Composable
fun headerHomeRoutines(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.header_routines),
            modifier = modifier
                .paddingFromBaseline(top = 30.dp, bottom = 8.dp)
                .padding(start = 20.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}
@Composable
fun cardExercise(
    imageResource:Int,
    kindExercise: String,
    numberOfExercises: String,
    modifier: Modifier = Modifier,
    exercises: String
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .border(1.dp, Color(0xFF1D4EA5), shape = RoundedCornerShape(8.dp))
    ){
        Row (
            modifier = Modifier
                .padding(top = 10.dp)
        ){
            Column (
                modifier = modifier
                    .padding(15.dp)

            ){
                Text(text = kindExercise,
                    color = Color(0xFF1D4EA5),
                    style = MaterialTheme.typography.titleLarge)
                Text(text = numberOfExercises)
            }
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .padding(top = 19.dp)
                    .size(45.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF1D4EA5),
                        shape = CircleShape
                    )
            )
        }
        Column {
            Text(text = exercises,
                modifier = modifier
                    .padding(bottom = 20.dp)
            )
        }
        lookExercise(onClick = {});
    }
}

@Composable
fun lookExercise(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF1D4EA5))
    ) {
        Text(text = stringResource(R.string.butto_look_routine))
    }
}

@Composable
fun routineCards() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(4) { index ->
            cardExercise(
                imageResource = when (index) {
                    0 -> R.drawable.brazos
                    1 -> R.drawable.espalda
                    2 -> R.drawable.pecho
                    3 -> R.drawable.pierna
                    else -> 0
                },
                kindExercise = when (index) {
                    0 -> "Rutina de brazos"
                    1 -> "Rutina de espalda"
                    2 -> "Rutina de pecho"
                    3 -> "Rutina de piernas"
                    else -> ""
                },
                numberOfExercises = "4 ejercicios",
                exercises = when (index){
                    0 -> "Curl con mancuernas\nCurl con barra\nCurl martillo\nCurl Antebrazo"
                    1 -> "Jalon al pecho\nRemo T\nRemo con barra\nJalon sentado"
                    2 -> "Press banca plano\nPress banca inclinado\nPress con mancuernas\nFondos"
                    3 -> "Sentadilla en Smith\nSentadilla Hack\nFemoral acostado\nPeso muerto con barra"
                    else -> ""
                }
            )
        }
    }
}
@Composable
fun routineExercisesBasic(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
        ){
            headerHomeRoutines();
            routineCards();
        }
    }
}
@Preview(showBackground = true)
@Composable
fun routineExercises(){
    routineExercisesBasic();
}

