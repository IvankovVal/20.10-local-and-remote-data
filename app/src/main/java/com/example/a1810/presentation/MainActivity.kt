package com.example.a1810.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a1810.R
import com.example.a1810.data.models.TaskModel
import com.example.a1810.presentation.viewModel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickListener {


    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private val model: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model.migration(this)

               // Specify layout for recycler view
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        val rb_group: RadioGroup = findViewById(R.id.fild_for_btns)
        var checkedRbtn:Int = rb_group.checkedRadioButtonId
        rb_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.btn_all-> getAllTasks()

                R.id.btn_complete-> getCompleteTasks()

                R.id.btn_active-> getActiveTasks()
            }}

        // Кнопка добавления задания
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val add_dialog = AddTaskDialog()
            val manager = supportFragmentManager
            add_dialog.show(manager,"add_dialog")
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Пункт $position нажат", Toast.LENGTH_LONG).show()
        val ditaile_dialog = DetailsDialog(position)
        val manager = supportFragmentManager
        ditaile_dialog.show(manager,"add_dialog")
    }

    override fun onCheckBoxClick(taskModel: TaskModel, isChecked: Boolean) {
    TODO()
    //model.onTaskCheckedChange(taskModel, isChecked)
    }

    fun getAllTasks(){
    model.loadTasks.observe(this, Observer {
    recyclerViewAdapter?.setList(this)
    recyclerViewAdapter?.notifyDataSetChanged()
    })
    }

    fun getCompleteTasks(){
        TODO()
    }

    fun getActiveTasks(){
        TODO()
    }


}