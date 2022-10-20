package com.example.a1810.presentation

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a1810.R
import com.example.a1810.data.models.TaskModel
import com.example.a1810.databinding.CustomViewBinding

class RecyclerViewAdapter (private val listener: OnItemClickListener)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private val tasksList = ArrayList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : CustomViewBinding = CustomViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    //________________________________________________________________________
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = tasksList[position].id.toString()
        holder.name.text = tasksList[position].name
        //holder.chekbox.isChecked = tasks[position]
        holder.chekbox.setOnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked){
                listener.onCheckBoxClick(tasksList[position], isChecked = true)
                holder.name.setTypeface(null, Typeface.ITALIC)
            }
            else{
                listener.onCheckBoxClick(tasksList[position], isChecked = false)
                holder.name.setTypeface(null, Typeface.BOLD)
            }
        }}




    //________________________________________________________________________
    override fun getItemCount(): Int {
        return tasksList.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class ViewHolder(val binding: CustomViewBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        val id: TextView = binding.tvId  //findViewById(R.id.tvId)
        val name: TextView = binding.tvName  //findViewById(R.id.tvName)
        val chekbox: CheckBox = binding.cbStatus  //findViewById(R.id.cbStatus)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)}
        }

    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
        fun onCheckBoxClick(taskModel: TaskModel,isChecked:Boolean)
            }

    fun setList(tasks: List<TaskModel>){
        tasksList.clear()
        tasksList.addAll(tasks)



    }

}