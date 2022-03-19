package com.example.palnotes.ui.adapter

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.palnotes.R
import com.example.palnotes.databinding.NotesItemlistBinding
import com.example.palnotes.model.Notes

class NotesAdapter(val requireContext: Context, private val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(val binding: NotesItemlistBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        return NotesViewHolder(NotesItemlistBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val data = notesList[position]
        holder.binding.noteTitle.text = data.title
        holder.binding.noteSubtitle.text = data.subtitle
        holder.binding.noteDate.text = data.date

        when(data.priority){

            "1"->{
                holder.binding.noteImp.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.noteImp.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.noteImp.setBackgroundResource(R.drawable.red_dot)
            }
        }
    }

    override fun getItemCount() = notesList.size

}