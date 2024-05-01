package edu.unicauca.personaltrainer.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "routine_exercises", primaryKeys = ["routine_id", "exercise_id"],
    foreignKeys = [
        ForeignKey(
            entity = RoutineEntity::class,
            parentColumns = ["routine_id"],
            childColumns = ["routine_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["exercise_id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class RoutineExercisesEntity(
    @ColumnInfo(name = "routine_id")
    val routineId:Int,
    @ColumnInfo("exercise_id")
    val exerciseId:Int
)