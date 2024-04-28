package edu.unicauca.personaltrainer.Personalized

import edu.unicauca.personaltrainer.R

object SampleExercises {
    val exerciseSample = listOf(
        Exercise(name = "Press inclinado con mancuernas",
            description =  "Ejercicio para pectorales superiores. Se realiza acostado en un banco inclinado, levantando y bajando las mancuernas sobre el pecho.",
            icon = R.drawable.bancoinclinado,
            muscles = listOf("Pecho")

        ),
        Exercise(name = "Press plano con mancuernas",
            description =  "Trabajo para pectorales. Se realiza acostado en un banco plano levantando y bajando las mancuernas a la altura del pecho.",
            icon = R.drawable.bancomancuernas,
            muscles = listOf("Pecho")
        ),
        Exercise(name = "Press plano con barra",
            description =  "Ejercicio clásico para pectorales. Se realiza acostado en un banco plano levantando y bajando la barra sobre el pecho.",
            icon = R.drawable.bancoinclinado,
            muscles = listOf("Pecho")
        ),
        Exercise(name = "Curl de bíceps con barra Z",
            description =  "Ejercicio para bíceps. Se realiza de pie, flexionando los codos y levantando la barra en forma de Z hacia los hombros.",
            icon = R.drawable.curl_barra,
            muscles = listOf("Bíceps")
        ),
        Exercise(name = "Curl de bíceps con mancuernas",
            description =  "Trabajo para bíceps. Se realiza de pie, flexionando los codos y levantando y bajando las mancuernas alternativamente.",
            icon = R.drawable.curl_biceps,
            muscles = listOf("Bíceps")
        ),
        Exercise(name = "Curl martillo",
            description =  "Ejercicio para bíceps y antebrazos. Se realiza de pie con mancuernas, levantando y bajando las pesas con las palmas mirando hacia dentro.",
            icon = R.drawable.curl_martillo,
            muscles = listOf("Bíceps")
        ),
        Exercise(name = "Femoral Acostado",
            description =  "Ejercicio para los músculos isquiotibiales. Se realiza acostado boca abajo en una máquina específica, flexionando y extendiendo las piernas.",
            icon = R.drawable.femoral,
            muscles = listOf("Femoral")
        ),
        Exercise(name = "Sentadilla hacka",
            description =  "Variante de sentadilla. Se realiza con una máquina específica con la barra detrás del cuerpo, trabajando especialmente los cuádriceps",
            icon = R.drawable.hacka,
            muscles = listOf("Cuádriceps")
        ),
        Exercise(name = "Fondos",
            description =  "Trabajo intenso para tríceps y pecho. Se realiza en barras paralelas bajando y subiendo el cuerpo.",
            icon = R.drawable.fondos,
            muscles = listOf("Pecho","Tríceps")
        )

    )
}