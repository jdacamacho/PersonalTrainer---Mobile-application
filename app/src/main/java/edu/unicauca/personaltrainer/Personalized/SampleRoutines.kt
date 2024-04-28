package edu.unicauca.personaltrainer.Personalized

import edu.unicauca.personaltrainer.R

object SampleRoutines {
    val routineSample:List<Routine> = listOf(
        Routine(
            tittle = "Lunes",
            icon = R.drawable.pecho,
            exercises = listOf(
                SampleExercises.exerciseSample[0],
                SampleExercises.exerciseSample[1],
                SampleExercises.exerciseSample[2],
                SampleExercises.exerciseSample[8]
            )
        ),
        Routine(
            tittle = "Martes",
            icon = R.drawable.musculos,
            exercises = listOf(
                SampleExercises.exerciseSample[3],
                SampleExercises.exerciseSample[4],
                SampleExercises.exerciseSample[5],
                SampleExercises.exerciseSample[6]
            )
        ),
        Routine(
            tittle = "Miercoles",
            icon = R.drawable.espalda,
            exercises = listOf(
                SampleExercises.exerciseSample[1],
                SampleExercises.exerciseSample[3],
                SampleExercises.exerciseSample[5],
                SampleExercises.exerciseSample[7]
            )
        )

    )
}