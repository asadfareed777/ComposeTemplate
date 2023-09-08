package pk.gov.pitb.composesample.data.datasource.api

import pk.gov.pitb.composesample.domain.model.Todo

interface TodoAPIDataSource {
    suspend fun getTodos(): List<Todo>
}