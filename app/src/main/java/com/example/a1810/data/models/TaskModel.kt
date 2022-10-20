package com.example.a1810.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_data_table")
data class TaskModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    var id : Int,

    @ColumnInfo(name = "task_name")
    var name : String,

    @ColumnInfo(name = "task_status")
    var status : String
)
