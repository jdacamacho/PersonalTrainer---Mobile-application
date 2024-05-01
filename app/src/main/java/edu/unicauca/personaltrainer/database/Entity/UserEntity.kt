package edu.unicauca.personaltrainer.database.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userid:Int,
    val userNames:String,
    val userLastNames:String,
    val userAge:Int,
    val userHeight: Double,
    val userWeight: Double,
    val userEmail: String,

    val userName: String,
    val userPassword: String
)