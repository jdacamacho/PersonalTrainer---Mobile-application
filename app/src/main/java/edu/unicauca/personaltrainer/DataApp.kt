package edu.unicauca.personaltrainer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class DataApp {
    companion object {
        @Composable
        fun getScreensData(): List<ScreenData> {
            return listOf(
                ScreenData(
                    text = "Rutinas",
                    textButton = stringResource(id = R.string.nav_rutines),
                    icon = painterResource(id = R.drawable.pesa)
                ),
                ScreenData(
                    text = "Personalizar",
                    textButton = stringResource(id = R.string.nav_personalitation),
                    icon = painterResource(id = R.drawable.lapiz)
                ),
                ScreenData(
                    text = "Ejercicios",
                    textButton = stringResource(id = R.string.nav_exercises),
                    icon = painterResource(id = R.drawable.levantamiento_de_pesas)
                ),
                ScreenData(
                    text = "Records",
                    textButton = stringResource(id = R.string.nav_records),
                    icon = painterResource(id = R.drawable.medalla)
                ),
                ScreenData(
                    text = "Yo",
                    textButton = stringResource(id = R.string.nav_me),
                    icon = painterResource(id = R.drawable.usuario)
                )

            )

        }
    }
}

data class ScreenData(
    val text: String,
    val textButton: String,
    val icon: Painter
)