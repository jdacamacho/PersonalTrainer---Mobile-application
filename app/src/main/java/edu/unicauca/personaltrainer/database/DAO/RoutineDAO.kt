package edu.unicauca.personaltrainer.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import edu.unicauca.personaltrainer.database.Entity.RoutineEntity

@Dao
interface RoutineDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(routine:RoutineEntity);
}