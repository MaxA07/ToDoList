package com.example.todolist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>
}