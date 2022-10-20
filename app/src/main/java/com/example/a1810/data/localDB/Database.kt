package com.example.a1810.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a1810.data.models.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract val tasksDao: TaskDao

}