package edu.unicauca.personaltrainer.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import edu.unicauca.personaltrainer.database.Entity.RoutineExercisesEntity
import edu.unicauca.personaltrainer.database.embedded.RoutineWithExercises

interface RoutineExercisesDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(routineExercise:RoutineExercisesEntity)

    @Transaction
    @Query("SELECT * FROM Routine")
    suspend fun getRoutineWithExercises():LiveData<List<RoutineExercisesEntity>>
}