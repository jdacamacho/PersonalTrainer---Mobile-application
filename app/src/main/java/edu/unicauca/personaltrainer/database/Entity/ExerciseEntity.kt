package edu.unicauca.personaltrainer.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercise")
data class ExerciseEntity(
    @PrimaryKey
    @ColumnInfo("exercise_id")
    val id:Int,
    val name:String,
    val icon:Int,
    val muscles:List<String>,
    val description:String,
)