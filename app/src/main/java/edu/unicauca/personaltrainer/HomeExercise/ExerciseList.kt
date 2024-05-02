package edu.unicauca.personaltrainer.HomeExercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.personaltrainer.Personalized.Exercise
import edu.unicauca.personaltrainer.Personalized.SampleExercises
import edu.unicauca.personaltrainer.R

@Composable
fun HeaderExercisesList(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.Header_exercise),
            modifier = modifier
                .paddingFromBaseline(top = 30.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
        Text(
            text = stringResource(R.string.Areas_exercises),
            modifier = modifier
                .paddingFromBaseline(top = 30.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Brazo", color = Color.Blue)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Espalda", color = Color.Blue)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Pecho", color = Color.Blue)
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Pierna", color = Color.Blue)
            }
        }
    }
}


@Composable
fun ImageLookExercisesList(
    modifier: Modifier = Modifier,
    imageResource:Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 10.dp, start = 50.dp, end = 50.dp, bottom = 20.dp)
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
fun cardExerciseDetails(
    kindExercise: String,
    imageResource: Int,
){
    HeaderLookExercise(kindExercise = kindExercise);
    ImageLookExercise(imageResource = imageResource);
}

@Composable
fun exercisesCards(exercises: List<Exercise>) {
    val selectedIndexes = remember { mutableListOf<Boolean>() }

    for (i in exercises.indices) {
        selectedIndexes.add(false)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(exercises) { exercise ->
            cardExerciseDetails(
                kindExercise = exercise.name,
                imageResource = exercise.icon,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExerciseMenu(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            HeaderExercisesList()
            exercisesCards(exercises = SampleExercises.exerciseSample)
        }
    }
}