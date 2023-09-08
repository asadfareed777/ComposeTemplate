package pk.gov.pitb.composesample.presentation.todo.todoList

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pk.gov.pitb.composesample.domain.model.Todo
import pk.gov.pitb.composesample.domain.usecase.GetTodos

class TodoListViewModel constructor(
    private val getTodosUseCase: GetTodos
) : ViewModel() {
    private val _todos = mutableStateListOf<Todo>()

    val todos: List<Todo>
        get() = _todos


    suspend fun getTodos() {
        viewModelScope.launch {
            _todos.addAll(getTodosUseCase())
        }
    }
}