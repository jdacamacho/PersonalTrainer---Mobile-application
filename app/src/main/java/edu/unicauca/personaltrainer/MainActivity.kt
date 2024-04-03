package edu.unicauca.personaltrainer


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
                    form()
                }
            }
        }
    }
}

/*********** Inicio de Formulario de registro **********/

@Composable
fun header(modifier: Modifier = Modifier){
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
                registerButtom(onClick = {});
            }
        }
    }
}

@Composable
fun registerButtom(onClick: () -> Unit) {
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
            header();
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

/*********** Inicio pagina de principal **********/

/*********** Inicio navegación **********/

