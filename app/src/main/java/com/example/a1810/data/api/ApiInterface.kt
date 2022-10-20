package com.example.a1810.data.api

import com.example.a1810.data.models.TasksApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("getAllTasks.php")
    fun getTasks(): Call<ArrayList<TasksApiModel>>
}