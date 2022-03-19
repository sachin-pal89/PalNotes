package com.example.palnotes.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.palnotes.R
import com.example.palnotes.databinding.FragmentHomeBinding
import com.example.palnotes.ui.adapter.NotesAdapter
import com.example.palnotes.viewmodel.NotesViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModelVar: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

       val allNotes = viewModelVar.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.notesList.layoutManager = GridLayoutManager(requireContext(),2)

            binding.notesList.adapter = NotesAdapter(requireContext(), notesList)
        }

        binding.addButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }


}