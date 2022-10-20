package com.example.a1810.data.repository.dataSourse

import androidx.lifecycle.LiveData
import com.example.a1810.data.models.TaskModel

interface TaskDataSource {

    fun insert(taskModel: TaskModel)

    fun loadTasks(): LiveData<List<TaskModel>>

    suspend fun clear()

}