package edu.unicauca.personaltrainer.HomeExercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.personaltrainer.R

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
fun lookExercise(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .padding(bottom = 20.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF1D4EA5))
    ) {
        Text(text = stringResource(R.string.butto_look_routine))
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
            .padding(16.dp)
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
fun routineCards() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(4) { index ->
            cardExercise(
                imageResource = when (index) {
                    0 -> R.drawable.musculo
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
                exercises = when (index) {
                    0 -> "Curl con mancuernas\nCurl con barra\nCurl martillo\nCurl Predicador"
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
    routineCards();
}
