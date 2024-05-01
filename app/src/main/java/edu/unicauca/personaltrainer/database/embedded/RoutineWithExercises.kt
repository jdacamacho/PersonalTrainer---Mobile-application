package edu.unicauca.personaltrainer.database.embedded

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import edu.unicauca.personaltrainer.database.Entity.ExerciseEntity
import edu.unicauca.personaltrainer.database.Entity.RoutineEntity
import edu.unicauca.personaltrainer.database.Entity.RoutineExercisesEntity

data class RoutineWithExercises(
    @Embedded
    var routine:RoutineEntity,
    @Relation(
        parentColumn = "routine_id",
        entity = RoutineEntity::class,
        entityColumn = "exercise_id",
        associateBy = Junction(
            value = RoutineExercisesEntity::class,
            parentColumn = "routine_id",
            entityColumn = "exercise_id"
        )
    )
    var exercises:List<ExerciseEntity>
)