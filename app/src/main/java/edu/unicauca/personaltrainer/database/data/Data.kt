package edu.unicauca.personaltrainer.database.data

import edu.unicauca.personaltrainer.R
import edu.unicauca.personaltrainer.database.Entity.RoutineEntity
import edu.unicauca.personaltrainer.database.Entity.UserEntity

data class User(val user:UserEntity ? = null, val routine:List<Int> ? = null)

data class UserResponse(
    val users:List<User> ? = null,
    val routines: List<RoutineEntity> ? = null
)

val response = UserResponse(
    listOf(
        User(
            UserEntity(
            1,
            "Santiago",
            "Benitez",
            21,
            1.68,
            63.4,
            "sbenitez@unicauca.edu.co",
            "sbenitez",
            "oracle"
            ),
            listOf(1,2,3)
        ),
        User(
            UserEntity(
                2,
                "Simon",
                "Guzman",
                22,
                1.79,
                85.2,
                "sguzman@unicauca.edu.co",
                "sguzman",
                "1234"
            ),
            listOf(2,3,4)
        ),
        User(
            UserEntity(
                3,
                "Julian David",
                "Camacho",
                22,
                1.76,
                83.4,
                "jdcamacho@unicauca.edu.co",
                "jdcamacho",
                "4567"
            ),
            listOf(3,4,5)
        )
    ),
    listOf(
        RoutineEntity(
            1,
            "Lunes",
            R.drawable.pecho
        ),
        RoutineEntity(
            2,
            "Martes",
            R.drawable.espalda
        ),
        RoutineEntity(
            3,
            "Miercoles",
            R.drawable.pierna
        ),
        RoutineEntity(
            4,
            "Jueves",
            R.drawable.pecho
        ),
        RoutineEntity(
            5,
            "Brazo",
            R.drawable.musculos
        ),
    )
)