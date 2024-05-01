package edu.unicauca.personaltrainer.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.unicauca.personaltrainer.database.Entity.UserEntity
import edu.unicauca.personaltrainer.database.Entity.UserRoutinesEntity

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: UserRoutinesEntity)

     @Query("SELECT * FROM User WHERE userName = :login AND  userPassword = :pass")
     suspend fun login(login:String, pass:String): UserEntity;
}