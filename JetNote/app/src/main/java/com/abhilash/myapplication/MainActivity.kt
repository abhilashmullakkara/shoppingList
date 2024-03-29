package com.abhilash.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhilash.myapplication.screen.NoteScreen
import com.abhilash.myapplication.screen.NoteViewModel
import com.abhilash.myapplication.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel:NoteViewModel by viewModels()
                    NoteApp(noteViewModel)
                }
            }
        }
    }
}
//want to check something new
@Composable
fun NoteApp(noteViewModel: NoteViewModel= viewModel()){
    val noteList=noteViewModel.getAllNote()
    NoteScreen(notes = noteList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteTheme {

    }
}