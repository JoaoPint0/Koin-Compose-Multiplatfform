package activity.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.rememberKoinInject

@Composable
fun ActivityListRoute(
    navigateToDetails: (String) -> Unit,
    viewModel: ActivityListViewModel = rememberKoinInject(),
) {
    val state by viewModel.uiState.collectAsState()
    ActivityListScreen(state, navigateToDetails, viewModel::update)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityListScreen(
    state: ActivityListUiState,
    navigateToDetails: (String) -> Unit,
    update: () -> Unit
) {

    Scaffold {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            item{
                Button(onClick = {
                    update()
                }){
                    Text("Fecth")
                }
            }

            items(state.list){
                Text(it.toString(), modifier = Modifier.clickable { navigateToDetails(it.toString()) })
            }
        }
    }
}