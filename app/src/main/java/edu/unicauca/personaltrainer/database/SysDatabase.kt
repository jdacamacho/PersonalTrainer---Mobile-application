package edu.unicauca.personaltrainer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.unicauca.personaltrainer.database.DAO.ExerciseDAO
import edu.unicauca.personaltrainer.database.DAO.RoutineDAO
import edu.unicauca.personaltrainer.database.DAO.RoutineExercisesDAO
import edu.unicauca.personaltrainer.database.DAO.UserDAO
import edu.unicauca.personaltrainer.database.DAO.UserRoutineDAO
import edu.unicauca.personaltrainer.database.Entity.ExerciseEntity
import edu.unicauca.personaltrainer.database.Entity.RoutineEntity
import edu.unicauca.personaltrainer.database.Entity.RoutineExercisesEntity
import edu.unicauca.personaltrainer.database.Entity.UserEntity
import edu.unicauca.personaltrainer.database.Entity.UserRoutinesEntity

@Database(
    version  = 1,
    entities = [
        UserEntity::class,
        ExerciseEntity::class,
        RoutineEntity::class,
        UserRoutinesEntity::class,
        RoutineExercisesEntity::class
    ],
    exportSchema = false
)

abstract class SysDatabase : RoomDatabase(){
    abstract fun exerciseDao(): ExerciseDAO
    abstract fun routineDao():RoutineDAO
    abstract fun routineExercisesDao(): RoutineExercisesDAO
    abstract fun userDao():UserDAO
    abstract fun userRoutinesDao():UserRoutineDAO

    companion object{
        private lateinit var INSTANCE:SysDatabase

        operator fun invoke(context: Context):SysDatabase{
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    SysDatabase::class.java, "sys_database"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}