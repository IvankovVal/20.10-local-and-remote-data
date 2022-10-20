package com.example.a1810.data.repository.dataSourseIMPL

import androidx.lifecycle.LiveData
import com.example.a1810.data.localDB.TaskDao
import com.example.a1810.data.models.TaskModel
import com.example.a1810.data.repository.dataSourse.TaskDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDataSourceIMPL  (private val dao: TaskDao):
    TaskDataSource {


    override fun insert(taskModel: TaskModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertTask(taskModel)}
    }

    override fun loadTasks(): LiveData<List<TaskModel>> {
        return dao.getAllTasks()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}