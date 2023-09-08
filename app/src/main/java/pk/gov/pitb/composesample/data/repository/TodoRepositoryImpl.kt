package pk.gov.pitb.composesample.data.repository

import pk.gov.pitb.composesample.data.datasource.api.TodoAPIDataSource
import pk.gov.pitb.composesample.domain.model.Todo
import pk.gov.pitb.composesample.domain.repository.TodoRepository

class TodoRepositoryImpl(private val datasource: TodoAPIDataSource) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return datasource.getTodos()
    }
}