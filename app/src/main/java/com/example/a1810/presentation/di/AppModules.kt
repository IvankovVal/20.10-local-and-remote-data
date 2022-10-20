package com.example.a1810.presentation.di

import androidx.room.Room
import com.example.a1810.data.localDB.Database
import com.example.a1810.data.repository.dataSourse.TaskApiDataSource
import com.example.a1810.data.repository.dataSourse.TaskDataSource
import com.example.a1810.data.repository.dataSourseIMPL.TaskApiDataSourceIMPL
import com.example.a1810.data.repository.dataSourseIMPL.TaskDataSourceIMPL
import com.example.a1810.data.repository.repository.TasksRepository
import com.example.a1810.domane.repository.TaskCall
import com.example.a1810.domane.useCase.TaskUseCase
import com.example.a1810.presentation.viewModel.TaskViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val moduleTasks = module{

    single {
        Room.databaseBuilder(androidContext(), Database::class.java,
            "localDB").build()
    }

    single { get<Database>().tasksDao }


    single<TaskDataSource> {
        TaskDataSourceIMPL(
            get()
        )
    }

    single<TaskApiDataSource> {
        TaskApiDataSourceIMPL(
            get()
        )
    }

    single<TaskCall> { TasksRepository(get(),get()) }

    single { TaskUseCase(get()) }

    viewModel { TaskViewModel(get()) }

}