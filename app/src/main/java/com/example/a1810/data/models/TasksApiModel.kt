package com.example.a1810.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TasksApiModel  (
    @SerializedName("id") @Expose
    var id: Int? = null,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("status") @Expose
    var status: String? = null

)