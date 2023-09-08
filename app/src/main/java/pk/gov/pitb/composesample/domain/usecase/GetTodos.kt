package pk.gov.pitb.composesample.domain.usecase

import pk.gov.pitb.composesample.domain.model.Todo
import pk.gov.pitb.composesample.domain.repository.TodoRepository

class GetTodos(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo> {
        return repository.getTodos()
    }
}