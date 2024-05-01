package edu.unicauca.personaltrainer.exercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.unicauca.personaltrainer.CurrentUser
import edu.unicauca.personaltrainer.Personalized.Exercise
import edu.unicauca.personaltrainer.Personalized.Routine
import edu.unicauca.personaltrainer.Personalized.SampleExercises
import edu.unicauca.personaltrainer.Personalized.SampleRoutines
import edu.unicauca.personaltrainer.R
import edu.unicauca.personaltrainer.ui.theme.BlueMain
import edu.unicauca.personaltrainer.ui.theme.Container
import edu.unicauca.personaltrainer.ui.theme.YellowSecondary

@Composable
fun ExerciseCard(exercise: Exercise, user: CurrentUser, navController: NavController)
{
    Row (
        Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
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
           Column {
               for(muscle in exercise.muscles){
                   Row{
                       Text(
                           text = "• $muscle",
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
fun ExerciseList(exercises: List<Exercise>, user: CurrentUser, navController: NavController)
{
    LazyColumn(
        Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(20.dp))
    ){
        items(exercises){
                element ->
            Row(
                Modifier
                    .background(Color.White)
            ){
                ExerciseCard(exercise = element, user= user, navController = navController)
            }
        }
    }
}

@Composable
fun ExercisesComplete(routine: Routine, user:CurrentUser, navController: NavController)
{
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 30.dp)
    ) {
        Text(
            text = stringResource(id = R.string.Exercises_Tittle) + ": " + routine.tittle,
            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 25.sp),
            color = BlueMain
        )
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 70.dp, end = 20.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {

        Row(
            Modifier
                .background(Container)
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(1f)
        ){
            LazyColumn(
                Modifier
                    .padding(top = 10.dp)
            ) {
                items(routine.exercises)
                {
                    element->
                    Row(
                        Modifier
                            .padding(top = 20.dp)
                    ){
                        ExerciseCard(exercise = element, user= user, navController = navController)
                    }

                }
            }
        }
    }
}
/*
@Preview
@Composable
fun PreviewExerciseCard()
{
    Surface {
        ExerciseCard(exercise = SampleExercises.exerciseSample[1])
    }
}

@Preview
@Composable
fun PreviewExerciseList()
{
    Surface{
        ExerciseList(exercises = SampleRoutines.routineSample[0].exercises)
    }

}

@Preview
@Composable
fun PreviewExercises()
{
    Surface {
        ExercisesComplete(routine = SampleRoutines.routineSample[1])
    }
}
 */