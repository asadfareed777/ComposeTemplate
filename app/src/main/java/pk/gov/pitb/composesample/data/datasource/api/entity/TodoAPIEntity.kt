package pk.gov.pitb.composesample.data.datasource.api.entity

import pk.gov.pitb.composesample.domain.model.Todo

data class TodoAPIEntity(
    val id: Int,
    val completed: Boolean,
    val title: String
)

fun TodoAPIEntity.toTodo(): Todo {
    return Todo(
        id = id,
        isCompleted = completed,
        task = title
    )
}