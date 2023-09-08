package pk.gov.pitb.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pk.gov.pitb.composesample.data.repository.TodoAPIImpl
import pk.gov.pitb.composesample.data.repository.TodoRepositoryImpl
import pk.gov.pitb.composesample.domain.usecase.GetTodos
import pk.gov.pitb.composesample.presentation.todo.todoList.TodoListView
import pk.gov.pitb.composesample.presentation.todo.todoList.TodoListViewModel
import pk.gov.pitb.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = TodoListViewModel(
            getTodosUseCase = GetTodos(
                repository = TodoRepositoryImpl(
                    datasource = TodoAPIImpl()
                )
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                TodoListView(vm)
            }
        }
    }
}