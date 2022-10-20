package com.example.a1810.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a1810.domane.useCase.TaskUseCase
import kotlinx.coroutines.launch

class TaskViewModel (private val taskUseCase: TaskUseCase):
    ViewModel() {

    val loadTasks = taskUseCase.loadTasks()

    fun migration(context: Context) = viewModelScope.launch {             //метод миграции данных
        taskUseCase.startMigration(context)

    }


}