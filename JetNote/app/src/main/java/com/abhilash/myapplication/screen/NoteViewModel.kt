package com.abhilash.myapplication.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.abhilash.myapplication.data.NotesDataSource
import com.abhilash.myapplication.model.Note

class NoteViewModel : ViewModel() {
    private var noteList= mutableStateListOf<Note>()
    init {
       noteList.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note: Note){
        noteList.add(note)

    }
    fun removeNote(note: Note){
        noteList.remove(note)

    }
    fun getAllNote():List<Note>{
        return noteList
    }

}