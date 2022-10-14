package com.example.todolist.db.repository

import androidx.lifecycle.LiveData
import com.example.todolist.db.dao.NoteDao
import com.example.todolist.model.NoteModel

class NoteRealisation(private val noteDao: NoteDao): NoteRepository {

    override val notesList: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }
}