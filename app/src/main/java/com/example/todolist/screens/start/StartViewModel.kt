package com.example.todolist.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todolist.REPOSITORY
import com.example.todolist.db.NoteDataBase
import com.example.todolist.db.repository.NoteRealisation
import com.example.todolist.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.notesList
    }
}