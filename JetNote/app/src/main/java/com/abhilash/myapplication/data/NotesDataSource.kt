package com.abhilash.myapplication.data

import com.abhilash.myapplication.model.Note

 class NotesDataSource {
   fun loadNotes ():List<Note>{
        return listOf(
            Note(title = "A good day", description = "Compose functon"),
              Note(title = "A goods day", description = "Ccompose functon"),
            Note(title = "A Poor day", description = "CJet Pack functon"),
            Note(title = "See the Difference", description = "Compose functon")




        )
    }


 }
