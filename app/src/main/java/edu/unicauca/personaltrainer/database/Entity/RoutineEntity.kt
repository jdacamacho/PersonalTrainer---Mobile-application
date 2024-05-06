package edu.unicauca.personaltrainer.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Routine")
data class RoutineEntity(
    @PrimaryKey
    @ColumnInfo(name = "routine_id")
    val routineId: Int,
    val routineTitle:String,
    val routineIcon:Int
)