package com.example.a1810.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a1810.data.models.TaskModel


@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(productModel: TaskModel)

    @Query("SELECT * FROM task_data_table")
    fun getAllTasks(): LiveData<List<TaskModel>>

    @Query("DELETE FROM task_data_table")
    suspend fun clear()


}