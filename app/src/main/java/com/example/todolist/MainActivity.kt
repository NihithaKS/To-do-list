package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todotitle: EditText =findViewById(R.id.todotitle)
        val addtodo: Button =findViewById(R.id.addtodo)
        val deletedone: Button =findViewById(R.id.deletedone)
        val todoitems: androidx.recyclerview.widget.RecyclerView =findViewById(R.id.todoitems)
        todoAdapter = TodoAdapter(mutableListOf())

        todoitems.adapter = todoAdapter
        todoitems.layoutManager = LinearLayoutManager(this)

        addtodo.setOnClickListener {
            val todoTitle = todotitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                todotitle.text.clear()
            }
        }
        deletedone.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}