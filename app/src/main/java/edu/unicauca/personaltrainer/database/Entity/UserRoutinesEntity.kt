package edu.unicauca.personaltrainer.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "user_routines", primaryKeys = ["user_id", "routine_id"],
    foreignKeys =
    [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = RoutineEntity::class,
            parentColumns = ["routine_id"],
            childColumns = ["routine_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class UserRoutinesEntity(
    @ColumnInfo(name = "user_id")
    val userId:Int,
    @ColumnInfo(name = "routine_id")
    val routineId:Int
)