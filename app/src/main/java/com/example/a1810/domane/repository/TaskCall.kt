package com.example.a1810.domane.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.a1810.data.models.TaskModel

interface TaskCall {

    fun loadTasks(): LiveData<List<TaskModel>>

    suspend fun startMigration(context: Context)

}