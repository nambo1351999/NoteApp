package com.phanphuongnam.noteapp.feature_note.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.phanphuongnam.noteapp.R
import com.phanphuongnam.noteapp.feature_note.presentation.notes.NotesEvent
import com.phanphuongnam.noteapp.feature_note.presentation.notes.components.NoteItem
import com.phanphuongnam.noteapp.feature_note.presentation.util.Screen
import com.phanphuongnam.noteapp.ui.theme.Black
import com.phanphuongnam.noteapp.ui.theme.Typography
import com.phanphuongnam.noteapp.ui.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.search),
                        style = Typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Add note",
                            tint = Black
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = White,
                    titleContentColor = Black,
                    actionIconContentColor = Black,
                    navigationIconContentColor = Black,
                    scrolledContainerColor = Black
                ),
            )
        },
        bottomBar = {},
        snackbarHost = {},
        floatingActionButton = {},

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = White),
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.notes.size) { note ->
                    NoteItem(
                        note = state.notes[note],
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    Screen.AddEditNoteScreen.route +
                                            "?noteId=${state.notes[note].id}&noteColor=${state.notes[note].color}"
                                )
                            },
                        onDeleteClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}