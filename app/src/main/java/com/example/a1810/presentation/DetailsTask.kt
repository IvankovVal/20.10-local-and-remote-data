package com.example.a1810.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a1810.databinding.DetaileDialogBinding
import com.example.a1810.presentation.viewModel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsDialog(var itemPosition: Int): BottomSheetDialogFragment() {

    private var binding: DetaileDialogBinding? = null

    private lateinit var model: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetaileDialogBinding.inflate(inflater,container,false)

       // var model: TaskViewModel by viewModel()

        //model = ViewModelProviders.of(requireActivity()).get(TaskViewModel::class.java)

        //положили в переменную конкретный пункт списка с которым будем работать
        //val task = model.allTasks.value!![itemPosition]


        //binding?.etNametaskDetails?.setText("${task.name}")

        //Кнопка выключения диалога
        binding?.btnCancel?.setOnClickListener {
            dialog?.cancel()
        }

        binding?.btnDelete?.setOnClickListener {

           // model.delete_task(task = task)
            dialog?.cancel()
        }

        binding?.btnEdit?.setOnClickListener {

            //в таск кладём id этого task и имя задачи из edittext
            //model.update_task(task = Task(task.id, binding?.etNametaskDetails?.text.toString(),task.status))

            dialog?.cancel()
        }


        return binding?.root
    }
}