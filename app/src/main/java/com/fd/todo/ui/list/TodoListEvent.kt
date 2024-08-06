package com.fd.todo.ui.list

import com.fd.todo.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}