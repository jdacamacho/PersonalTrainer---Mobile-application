package edu.unicauca.personaltrainer.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import edu.unicauca.personaltrainer.database.Entity.UserRoutinesEntity
import edu.unicauca.personaltrainer.database.SysDatabase
import edu.unicauca.personaltrainer.database.data.response
import edu.unicauca.personaltrainer.database.embedded.UserRoutines


class UserRepository (private val context:Context){
    private val userDAO = SysDatabase(context = context).userDao()
    private val routineDAO = SysDatabase(context = context).routineDao()
    private val userRoutineDAO = SysDatabase(context = context).userRoutinesDao()

    private var userRoutinesList: MutableList<UserRoutinesEntity> = mutableListOf()

    suspend fun insertTODB(){
        response.users?.forEach{
            it.user?.let {
                us -> this.userDAO.insert(us)
            }
        }
        response.routines

        response.routines?.forEach {
            this.routineDAO.insert(it)
        }

        response.users?.forEach{
            user ->
                user.routine?.forEach{
                    routineId ->
                        user.user?.userid?.let { userId ->
                            UserRoutinesEntity(userId, routineId) }?.let { userRoutineId ->
                                userRoutinesList.add(userRoutineId) }
                }
        }

        userRoutinesList.forEach {
            this.userRoutineDAO.insert(it)
        }
    }
    /*
    suspend fun fetch(): LiveData<List<UserRoutines>> {
        val data = this.userRoutineDAO.getAll()
        data.value?.forEach {
            Log.d("BookWithAuthors", it.toString())
        }
        return data
    }
    */
}