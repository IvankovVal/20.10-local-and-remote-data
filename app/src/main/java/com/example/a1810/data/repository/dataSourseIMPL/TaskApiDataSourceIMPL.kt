package com.example.a1810.data.repository.dataSourseIMPL

import android.content.Context
import android.widget.Toast
import com.example.a1810.data.api.ApiClient
import com.example.a1810.data.models.TaskModel
import com.example.a1810.data.models.TasksApiModel
import com.example.a1810.data.repository.dataSourse.TaskApiDataSource
import com.example.a1810.data.repository.dataSourse.TaskDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskApiDataSourceIMPL (private val taskDataSource: TaskDataSource):
    TaskApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.getTasks()
        call?.enqueue(object: Callback<ArrayList<TasksApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<TasksApiModel>>,
                response: Response<ArrayList<TasksApiModel>>
            ) {


                var loadTasks: ArrayList<TasksApiModel>? = null

                loadTasks?.clear()

                loadTasks = (response.body() as ArrayList<TasksApiModel>?)!!

                for (audit in loadTasks) {

                    audit.id?.let {
                        TaskModel(
                            it,
                            audit.name.toString(),
                            audit.status.toString())



                    }?.let {
                        taskDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<TasksApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}