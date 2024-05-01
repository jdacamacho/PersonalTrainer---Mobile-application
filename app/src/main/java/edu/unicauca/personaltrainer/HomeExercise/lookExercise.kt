package edu.unicauca.personaltrainer.HomeExercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import edu.unicauca.personaltrainer.Personalized.SampleExercises
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
    val selectedIndexes = listOf(3, 4, 5, 6);

    val selectedExercises = selectedIndexes.mapNotNull { index ->
        if (index in SampleExercises.exerciseSample.indices) {
            SampleExercises.exerciseSample[index];
        } else {
            null;
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(selectedExercises) { exercise ->
            cardExerciseDetails(
                kindExercise = exercise.name,
                imageResource = exercise.icon,
                repeats = "12 repeticiones x 4 sets"
            )
        }
    }
}

@Composable
fun routineCardBack() {
    val selectedIndexes = listOf(12, 13, 14, 15);

    val selectedExercises = selectedIndexes.mapNotNull { index ->
        if (index in SampleExercises.exerciseSample.indices) {
            SampleExercises.exerciseSample[index];
        } else {
            null;
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(selectedExercises) { exercise ->
            cardExerciseDetails(
                kindExercise = exercise.name,
                imageResource = exercise.icon,
                repeats = "12 repeticiones x 4 sets"
            )
        }
    }
}


@Composable
fun routineCardChest() {
    val selectedIndexes = listOf(0, 1, 2, 11);

    val selectedExercises = selectedIndexes.mapNotNull { index ->
        if (index in SampleExercises.exerciseSample.indices) {
            SampleExercises.exerciseSample[index];
        } else {
            null;
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(selectedExercises) { exercise ->
            cardExerciseDetails(
                kindExercise = exercise.name,
                imageResource = exercise.icon,
                repeats = "12 repeticiones x 4 sets"
            )
        }
    }
}


@Composable
fun routineCardLegs() {

    val selectedIndexes = listOf(7, 8, 9, 10);

    val selectedExercises = selectedIndexes.mapNotNull { index ->
        if (index in SampleExercises.exerciseSample.indices) {
            SampleExercises.exerciseSample[index];
        } else {
            null;
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(selectedExercises) { exercise ->
            cardExerciseDetails(
                kindExercise = exercise.name,
                imageResource = exercise.icon,
                repeats = "12 repeticiones x 4 sets"
            )
        }
    }
}

@Composable
fun basicChest(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            HeaderPrincipalLookExercise();
            routineCardChest();
        }
    }
}

@Composable
fun basicLegs(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            HeaderPrincipalLookExercise();
            routineCardLegs();
        }
    }
}

@Composable
fun basicArms(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            HeaderPrincipalLookExercise();
            routineCardArms();
        }
    }
}

@Composable
fun basicBack(){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            HeaderPrincipalLookExercise();
            routineCardBack();
        }
    }
}

@Preview(showBackground = true)
@Composable
fun routineLookExercise(){
    basicArms();
}