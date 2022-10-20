package com.example.a1810.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.a1810.data.models.TaskModel
import com.example.a1810.data.repository.dataSourse.TaskApiDataSource
import com.example.a1810.data.repository.dataSourse.TaskDataSource
import com.example.a1810.domane.repository.TaskCall

class TasksRepository (private val taskApiDataSource: TaskApiDataSource,
                       private val taskDataSource: TaskDataSource
): TaskCall {

    override fun loadTasks(): LiveData<List<TaskModel>> {
        return taskDataSource.loadTasks()
    }

    override suspend fun startMigration(context: Context) {
        taskDataSource.clear()
        taskApiDataSource.startMigration(context)
    }

}