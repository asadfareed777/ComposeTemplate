package pk.gov.pitb.composesample.domain.repository

import pk.gov.pitb.composesample.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>

}