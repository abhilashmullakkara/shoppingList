package com.abhilash.myapplication.data

import androidx.room.*
import com.abhilash.myapplication.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_tbl")
    fun getNotes():Flow<List<Note>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)
    @Query("DELETE * from notes_tbl")
    suspend fun deleteAll()
    @Delete
    suspend fun deleteNote(note: Note)

}
