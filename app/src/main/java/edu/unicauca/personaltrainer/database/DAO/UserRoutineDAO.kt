package edu.unicauca.personaltrainer.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.unicauca.personaltrainer.database.Entity.UserEntity
import edu.unicauca.personaltrainer.database.Entity.UserRoutinesEntity
import edu.unicauca.personaltrainer.database.embedded.UserRoutines
import kotlinx.coroutines.flow.Flow

@Dao
interface UserRoutineDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: UserRoutinesEntity)

    @Query("SELECT * FROM User ")
    suspend fun getAll():Flow<UserRoutinesEntity>

    @Query("SELECT * FROM User WHERE user_id = :id")
    suspend fun getuserById(id:Int):Flow<UserRoutinesEntity>
}