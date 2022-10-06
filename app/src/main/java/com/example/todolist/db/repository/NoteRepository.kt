package com.example.todolist.db.repository

import androidx.lifecycle.LiveData
import com.example.todolist.model.NoteModel

interface NoteRepository {

    val notesList: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)

    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
}