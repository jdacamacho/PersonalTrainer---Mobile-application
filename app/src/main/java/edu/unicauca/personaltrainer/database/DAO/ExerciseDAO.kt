package edu.unicauca.personaltrainer.database.DAO


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import edu.unicauca.personaltrainer.database.Entity.ExerciseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(exercise: ExerciseEntity);
    @Transaction
    @Query("SELECT * FROM Exercise")
    suspend fun getExercises():Flow<List<ExerciseEntity>>
}