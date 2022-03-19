package com.example.palnotes.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.palnotes.model.Notes


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id = :id")
    fun deleteNotes(id: Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNotes(notes: Notes)
}