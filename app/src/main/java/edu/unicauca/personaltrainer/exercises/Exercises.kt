package edu.unicauca.personaltrainer.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.unicauca.personaltrainer.Personalized.Exercise
import edu.unicauca.personaltrainer.Personalized.RoutineCard
import edu.unicauca.personaltrainer.Personalized.SampleExercises
import edu.unicauca.personaltrainer.Personalized.SampleRoutines
import edu.unicauca.personaltrainer.ui.theme.BlueMain
import edu.unicauca.personaltrainer.ui.theme.Container
import edu.unicauca.personaltrainer.ui.theme.YellowSecondary

@Composable
fun ExerciseCard(exercise: Exercise)
{
    Row (
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp))
            .padding(bottom = 10.dp)
    ){
       Column(
           Modifier
               .padding(top = 20.dp, start = 20.dp)
               .weight(1f)
       ) {
            Row(

            ) {
                Text(
                    text = exercise.name,
                    style = TextStyle(
                        color = BlueMain,
                        fontWeight = FontWeight.SemiBold),
                        fontSize = 20.sp
                )
            }
           LazyColumn {
               items(exercise.muscles){
                   Row{
                       Text(
                           text = "• $it",
                           style = TextStyle(
                               color = BlueMain,
                               fontWeight = FontWeight.SemiBold),
                           fontSize = 15.sp
                           )
                   }
               }
           }
           Row(
               Modifier
                   .padding(end = 10.dp)
           ){
               Text(text = exercise.description)
           }
       }
        Column(
            Modifier
                .size(width = 160.dp, height = 200.dp)
                .padding(end = 20.dp, top = 30.dp)
        ) {
            Image(
                painter = painterResource(id = exercise.icon),
                contentDescription = exercise.name,
                modifier = Modifier.size(150.dp))
        }
    }
}

@Composable
fun ExerciseList(exercises: List<Exercise>)
{
    LazyColumn(
        Modifier
            .padding(horizontal = 20.dp)
    ){
        items(exercises){
                element ->
            ExerciseCard(exercise = element)
        }
    }
}
@Preview
@Composable
fun PreviewExerciseCard()
{
    ExerciseCard(exercise = SampleExercises.exerciseSample[1])
}

@Preview
@Composable
fun PreviewExerciseList()
{
    ExerciseList(exercises = SampleRoutines.routineSample[0].exercises)
}