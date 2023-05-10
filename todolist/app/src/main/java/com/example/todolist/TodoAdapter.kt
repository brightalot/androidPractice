package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding

class TodoAdapter(private val todos: List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {
        //ViewHoler 만들기
        val binding = ItemTodoBinding.inflate(

            //context는 이미 parent(ViewGroup에 존재함)
            LayoutInflater.from(parent.context),

            //속해있을 패런트
            parent,

            false
        )
        return TodoViewHolder(binding).also {holder ->
            binding.completedCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                //holder 자체가 position을 가지고 있으니 adapterPosition을 이용해주면됨
                //adapterPosition은 noPosition 값을 가질 수 있음 -> getOrNull을 사용해서 인자가 없으면 null값을 반환하도록 함
                todos.getOrNull(holder.adapterPosition)?.completed = isChecked
            }
        }

    }

    //훨씬 자주 호출됨, 정보 바인딩(뷰가 정상적으로 보임)
    //position 은 list 상에서 몇번째인지
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        holder.adapterPosition == position (?)
        holder.bind(todos[position])

//        holder.binding.completedCheckBox.setOnCheckedChangeListener {buttonView, isChecked ->
//            todos[position].completed = !isChecked
//        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
//    override fun getItemCount(): Int = todos.size

    class TodoViewHolder(private val binding: ItemTodoBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(todo: Todo) {
                binding.todoTitleText.text = todo.title
                binding.completedCheckBox.isChecked = todo.completed
            }
    }
}