package edu.unicauca.personaltrainer.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.personaltrainer.Auth.fieldForm
import edu.unicauca.personaltrainer.R
import edu.unicauca.personaltrainer.ui.theme.PersonalTrainerTheme

@Composable
fun headerForm(modifier: Modifier = Modifier){
    Spacer(modifier = Modifier.height(64.dp))
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
        Spacer(modifier = Modifier.height(32.dp))
        val title = stringResource(R.string.Title_Register)
        Text(
            text = "Bienvenido a $title",
            modifier = modifier.paddingFromBaseline(top = 30.dp , bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = Color(0xFF1D4EA5)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.Slogan_register),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SignIn(modifier: Modifier = Modifier){
    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        PersonalTrainerTheme {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(100.dp))
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp),
                    ) {
                        items(2) { index ->
                            fieldForm(
                                textField = when (index) {
                                    0 -> stringResource(R.string.UserName_Login)
                                    1 -> stringResource(R.string.Password_register)
                                    else -> ""
                                },
                                textPlaceHolder = when (index) {
                                    0 -> stringResource(R.string.UserName_placeHolderLogin)
                                    1 -> stringResource(R.string.Password_placeHolder)
                                    else -> ""
                                }

                            )
                        }
                        item{
                            Spacer(modifier = Modifier.height(32.dp))
                            edu.unicauca.personaltrainer.Auth.registerButtomForm(onClick = {});
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun registerButtomForm(onClick: () -> Unit) {
    // Botón de inicio de sesión
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.Blue),
        modifier = Modifier.size(100.dp, 50.dp)
    ) {
        Text(text = "Iniciar Sesion")
    }
}

@Composable
fun LoginPage(modifier: Modifier = Modifier){
    Surface (
        modifier = Modifier.fillMaxSize()
    ){
        Column {
            headerForm()
            SignIn()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignInPreview(){
    PersonalTrainerTheme {
        LoginPage()
    }
}
