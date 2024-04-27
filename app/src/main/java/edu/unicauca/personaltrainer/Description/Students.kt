package edu.unicauca.personaltrainer.Description

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.personaltrainer.HomeExercise.cardExerciseDetails
import edu.unicauca.personaltrainer.R

@Composable
fun headerDescription(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.title_description) ,
            modifier = modifier
                .padding(bottom = 20.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}

@Composable
fun Description(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        headerDescription();
        Text(
            text = stringResource(R.string.description),
            style = MaterialTheme.typography.bodyLarge ,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
        Text(text = "Desarrolladores:",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF1D4EA5)
        )
    }
}

@Composable
fun cardStudent(
    modifier: Modifier = Modifier,
    imageResource:Int,
    descriptionStudent:String
) {
    Row(
        modifier = Modifier
            .padding(top = 120.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            .fillMaxWidth()
            .height(150.dp)
            .border(1.dp, Color(0xFF1D4EA5), shape = RoundedCornerShape(0.dp))
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
        )
        Text(
            modifier = Modifier.padding(top = 10.dp, start = 6.dp, end = 6.dp),
            textAlign = TextAlign.Justify,
            text = descriptionStudent)
    }
}

@Composable
fun developers(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        items(4) { index ->
            cardStudent(
                imageResource = when (index) {
                    0 -> R.drawable.camacho
                    1 -> R.drawable.benitez
                    2 -> R.drawable.simon
                    else -> 0
                },
                descriptionStudent = when (index) {
                    0 -> stringResource(R.string.description_camacho)
                    1 -> stringResource(R.string.description_benitez)
                    2 -> stringResource(R.string.descripcion_simon)
                    else -> ""
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewDescription(){
    //Description()
    developers()
}

