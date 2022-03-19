package com.example.palnotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.palnotes.database.NotesDatabase
import com.example.palnotes.model.Notes
import com.example.palnotes.repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NotesRepository

    init{

        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }
}