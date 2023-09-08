package pk.gov.pitb.composesample.presentation.todo.todoList

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListView(vm: TodoListViewModel) {

    LaunchedEffect(Unit, block = {
        vm.getTodos()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Todos")
                }
            )
        },
        content = {
            var showLoader by remember {
                mutableStateOf(true)
            }
            Box (contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                Column(modifier = Modifier.padding(16.dp)) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        showLoader = vm.todos.isEmpty()
                        items(vm.todos) { todo ->
                            Row(modifier = Modifier.padding(16.dp)) {
                                Checkbox(checked = todo.isCompleted, onCheckedChange = null)
                                Spacer(Modifier.width(5.dp))
                                Text(todo.task)
                            }
                            Divider()
                        }
                    }
                }
                AnimatedVisibility(visible = showLoader) {
                    CircularProgressIndicator()
                }
            }
        },
        bottomBar = {
            BottomAppBar (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
            ){
                var selection by remember{
                    mutableStateOf(0)
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Surface(onClick = {selection = 0}) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription ="",Modifier.size(35.dp), tint = if(selection == 0) Color.Magenta else Color.White)
                    }
                    Surface(onClick = {selection = 1}) {
                        Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription ="",Modifier.size(35.dp),tint = if(selection == 1) Color.Magenta else Color.White)

                    }
                    Surface(onClick = {selection = 2}) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription ="",Modifier.size(35.dp),tint = if(selection == 2) Color.Magenta else Color.White)

                    }
                    Surface(onClick = {selection = 3}) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription ="",Modifier.size(35.dp),tint = if(selection == 3) Color.Magenta else Color.White)
                    }
                }
            }
        }
    )
}