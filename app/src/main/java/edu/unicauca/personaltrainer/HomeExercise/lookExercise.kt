package edu.unicauca.personaltrainer.HomeExercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
fun HeaderPrincipalLookExercise(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.header_routines),
            modifier = modifier
                .paddingFromBaseline(top = 30.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}

@Composable
fun HeaderLookExercise(
    modifier: Modifier = Modifier,
    kindExercise: String
    ){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = kindExercise,
            modifier = modifier
                .paddingFromBaseline(top = 30.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}

@Composable
fun ImageLookExercise(
    modifier: Modifier = Modifier,
    imageResource:Int,
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(200.dp)
            .border(1.dp, Color(0xFF1D4EA5), shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(200.dp)
        )
    }
}

@Composable
fun FooterLookExercise(
    modifier: Modifier = Modifier,
    repeats: String){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = repeats,
            modifier = modifier
                .paddingFromBaseline(top = 0.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}

@Composable
fun cardExerciseDetails(
    kindExercise: String,
    imageResource: Int,
    repeats: String
){
    HeaderLookExercise(kindExercise = kindExercise);
    ImageLookExercise(imageResource = imageResource);
    FooterLookExercise(repeats = repeats);
}

@Composable
fun routineCardArms() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(4) { index ->
            cardExerciseDetails(
                kindExercise = when (index) {
                    0 -> "Hola"
                    1 -> "Hola"
                    2 -> ""
                    3 -> ""
                    else -> ""
                },
                imageResource = when (index) {
                    0 -> R.drawable.brazos
                    1 -> R.drawable.espalda
                    2 -> R.drawable.pecho
                    3 -> R.drawable.pierna
                    else -> 0
                },
                repeats = when (index){
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

@Preview(showBackground = true)
@Composable
fun routineLookExercise(){
    routineCardArms();
}