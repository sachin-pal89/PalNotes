package com.example.palnotes.repository

import androidx.lifecycle.LiveData
import com.example.palnotes.dao.NotesDao
import com.example.palnotes.model.Notes

class NotesRepository(private val dao: NotesDao) {

    fun getAllNotes():LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}