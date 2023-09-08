package pk.gov.pitb.composesample.data.repository

import pk.gov.pitb.composesample.data.datasource.api.TodoAPIDataSource
import pk.gov.pitb.composesample.data.datasource.api.entity.TodoAPIEntity
import pk.gov.pitb.composesample.data.datasource.api.entity.toTodo
import pk.gov.pitb.composesample.domain.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TodoApi {

    @GET("todos")
    suspend fun getTodos(): List<TodoAPIEntity>

    companion object {
        var todoApi: TodoApi? = null
        fun getInstance(): TodoApi {
            if (todoApi == null) {
                todoApi = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodoApi::class.java)
            }
            return todoApi!!
        }
    }
}

class TodoAPIImpl : TodoAPIDataSource {

    override suspend fun getTodos(): List<Todo> {
        return TodoApi.getInstance().getTodos().map { it.toTodo() }
    }
}