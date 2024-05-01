package edu.unicauca.personaltrainer.Personalized

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.unicauca.personaltrainer.AppRoute
import edu.unicauca.personaltrainer.CurrentUser
import edu.unicauca.personaltrainer.NavItem
import edu.unicauca.personaltrainer.R
import edu.unicauca.personaltrainer.exercises.ExercisesComplete
import edu.unicauca.personaltrainer.ui.theme.BlueMain
import edu.unicauca.personaltrainer.ui.theme.Container
import edu.unicauca.personaltrainer.ui.theme.YellowSecondary


@Composable
fun PersonalizedVoid(){
    Row (
        Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 60.dp)
            .clip(RoundedCornerShape(20.dp)),
        )
    {
        Column(
            Modifier
                .background(color = Container),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                Modifier.padding(top = 80.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.personalize_void),
                    contentDescription = stringResource(id = R.string.Perzonalize_TItle),
                    Modifier.size(width = 200.dp, height = 200.dp)
                )
            }
            Row()
            {
                Text(
                    text = stringResource(id = R.string.void_rutine_text),
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 35.sp),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp),
                    lineHeight = 24.sp
                )
            }
            Row(Modifier.padding(top = 15.dp ,bottom = 50.dp)){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(YellowSecondary)
                ) {
                    Text(text = stringResource(id = R.string.start_button),
                        color = BlueMain,
                        style = TextStyle(fontSize = 30.sp), fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
data class Exercise(val name:String, val description: String, val icon: Int, val muscles:List<String>)
data class Routine (val tittle:String, val icon:Int, val exercises:List<Exercise>)
@Composable
fun RoutineCard(routine:Routine, navController: NavController, user: CurrentUser, pos:Int){
    Row (
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .clip(RoundedCornerShape(10.dp))
    ){
        Column(
            Modifier
                .background(Container)
        ){
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(bottom = 20.dp)

            )
            {
                Column(
                    Modifier
                        .padding(start = 20.dp)
                        .weight(1f)
                ){
                    Row (

                    ){
                        Text(
                            text = routine.tittle,
                            style = TextStyle(
                                color = BlueMain,
                                fontWeight = FontWeight.SemiBold),
                            fontSize = 20.sp
                        )
                    }
                    Row {
                        Text(
                            text = "${routine.exercises.size} ejercicios",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold
                            ),
                            fontSize = 15.sp
                        )
                    }
                }
                Column (Modifier
                    .padding(end = 30.dp)        )
                {
                    Image(painter = painterResource(
                                        id = routine.icon),
                                        contentDescription = routine.tittle,
                                        modifier = Modifier .size(50.dp)
                        )

                }
            }
            routine.exercises.forEach{
                Row(
                    Modifier
                        .padding(start = 25.dp)
                ){
                    Text(
                        text = it.name, style = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        ),
                        fontSize = 15.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.End){
                Button(

                    onClick = {
                        user.exercises = routine.exercises
                        user.option = pos
                        navController.navigate(AppRoute.ExercisesRoutine)
                              },
                    colors = ButtonDefaults.buttonColors(YellowSecondary),
                    modifier = Modifier .weight(1f)
                ) {
                    Text(text = "Ver ejercicios",
                        color = BlueMain,
                        style = TextStyle(fontSize = 15.sp),
                        fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
@Composable
fun RoutineList(routines: List<Routine>, navController: NavController, user: CurrentUser)
{
    LazyColumn(
        Modifier
            .padding(horizontal = 20.dp)
    ){
        var i:Int = 0
        items(routines){
            element ->
                RoutineCard(routine = element, navController, user = user, pos = i++)
        }
    }
}
@Composable
fun Personalize(user:CurrentUser, navController: NavController)
{
    Column (
        Modifier.fillMaxWidth()
    )
    {
        Row(
            Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Perzonalize_TItle),
                style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 25.sp),
                color = BlueMain
            )
        }
        if(user.routines.isNotEmpty())
        {
            Row {
                RoutineList(routines = user.routines, navController, user = user)
            }
        }
        else
        {
            Row {
                PersonalizedVoid()
            }
        }

    }
}
@Preview
@Composable
fun PreviewVoid()
{
    Surface {
        PersonalizedVoid()
    }
}
/*
@Preview
@Composable
fun PreviewRoutineCard()
{
    Surface{
        RoutineCard(SampleRoutines.routineSample[0])
    }
}

@Preview
@Composable
fun PreviewRoutineList()
{
    Surface{
        RoutineList(routines = SampleRoutines.routineSample)
    }
}
@Preview
@Composable
fun PreviewPersonalizeVoid()
{
    Surface {
        Personalize(routines = listOf())
    }
}

@Preview
@Composable
fun PreviewPersonalizeItems()
{
    Surface {
        Personalize(routines = SampleRoutines.routineSample)
    }
}
*/
