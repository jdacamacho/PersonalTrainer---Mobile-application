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
            icon = R.drawable.bancoplano,
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
        Exercise(name = "Curl predicador",
            description = "Ejercicio para bíceps en banco especial. Flexiona los codos y levanta mancuernas alternativamente para fortalecer y desarrollar los bíceps.",
            icon = R.drawable.predicador_biceps,
            muscles = listOf("Biceps")

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
        Exercise(name = "Sentadilla Smith",
            description = "",
            icon = R.drawable.sentadillasmith,
            muscles = listOf("Se realiza en una máquina Smith. Flexiona las rodillas y las caderas para bajar el cuerpo, luego regresa a la posición inicial. Trabaja cuádriceps, glúteos y músculos isquiotibiales.")
        ),
        Exercise(name = "Peso muerto con mancuernas",
            description = "El Peso muerto con mancuernas fortalece la cadena posterior. De pie, flexiona caderas y rodillas para bajar las mancuernas hacia el suelo, luego vuelve a la posición inicial. Trabaja glúteos, espalda baja e isquiotibiales.",
            icon = R.drawable.pesomuertp,
            muscles = listOf("Femoral")

        ),
        Exercise(name = "Fondos",
            description =  "Trabajo intenso para tríceps y pecho. Se realiza en barras paralelas bajando y subiendo el cuerpo.",
            icon = R.drawable.fondos,
            muscles = listOf("Pecho","Tríceps")
        ),
        Exercise(name = "Jalon al pecho",
            description = "El Jalon al pecho es un ejercicio para el músculo del pecho. Se realiza tirando de una barra hacia el pecho desde una posición elevada. Fortalece los músculos del pecho y los brazos.",
            icon = R.drawable.jalonalpecho,
            muscles = listOf("Pecho")
        ),
        Exercise(name = "Remo T",
            description = "Es un ejercicio que se enfoca en el desarrollo del pecho. Se realiza levantando una barra desde una posición baja hasta el nivel del pecho, manteniendo los codos elevados y apretando los omóplatos. Fortalece el pecho y los músculos de la espalda.",
            icon = R.drawable.remot,
            muscles = listOf("Pecho")
        ),
        Exercise(name = "Remo con barra",
            description = "Es un ejercicio para el pecho. Se realiza tirando de una barra hacia el cuerpo desde una posición inclinada, manteniendo la espalda recta y los codos cerca del cuerpo. Fortalece el pecho y los músculos de la espalda.",
            icon = R.drawable.remoconbarra,
            muscles = listOf("Pecho")
        ),
        Exercise(name = "Jalon sentado",
            description = "El Jalon sentado es un ejercicio que trabaja el pecho. Se realiza sentado en una máquina, tirando de una barra hacia abajo hacia el pecho. Fortalece los músculos del pecho y los brazos.",
            icon = R.drawable.remosentado,
            muscles = listOf("Pecho")

        )

    )
}