package com.example.a1810.domane.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.a1810.data.models.TaskModel
import com.example.a1810.domane.repository.TaskCall

class TaskUseCase (private val taskCall: TaskCall) {


    fun loadTasks(): LiveData<List<TaskModel>> {

        return taskCall.loadTasks()

    }

    suspend fun startMigration (context: Context) {

        taskCall.startMigration(context)

    }



}