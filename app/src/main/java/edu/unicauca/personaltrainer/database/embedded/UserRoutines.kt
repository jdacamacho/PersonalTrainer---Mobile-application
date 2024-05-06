package edu.unicauca.personaltrainer.database.embedded

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import edu.unicauca.personaltrainer.database.Entity.RoutineEntity
import edu.unicauca.personaltrainer.database.Entity.UserEntity

data class UserRoutines (
    @Embedded
    var user:UserEntity,
    @Relation(
        parentColumn = "user_id",
        entity = UserEntity::class,
        entityColumn = "routine_id",
        associateBy = Junction(
            value = UserEntity::class,
            parentColumn = "user_id",
            entityColumn = "routine_id"
        )
    )
    var routines:List<RoutineEntity>
)
