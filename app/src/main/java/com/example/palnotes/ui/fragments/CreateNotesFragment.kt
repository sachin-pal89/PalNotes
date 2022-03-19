package com.example.palnotes.ui.fragments


import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.palnotes.R
import com.example.palnotes.databinding.FragmentCreateNotesBinding
import com.example.palnotes.model.Notes
import com.example.palnotes.viewmodel.NotesViewModel
import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    private val viewModelVar: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

       binding.okButton.setOnClickListener{
           createNotes(it)
       }

        binding.greenDots.setImageResource(R.drawable.ic_baseline_check_24)

        binding.greenDots.setOnClickListener{
           priority = "1"
           binding.greenDots.setImageResource(R.drawable.ic_baseline_check_24)
           binding.redDots.setImageResource(0)
           binding.yellowDots.setImageResource(0)
        }

        binding.yellowDots.setOnClickListener{
            priority = "2"
            binding.yellowDots.setImageResource(R.drawable.ic_baseline_check_24)
            binding.redDots.setImageResource(0)
            binding.greenDots.setImageResource(0)
        }

        binding.redDots.setOnClickListener{
            priority="3"
            binding.redDots.setImageResource(R.drawable.ic_baseline_check_24)
            binding.yellowDots.setImageResource(0)
            binding.greenDots.setImageResource(0)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {

        val title = binding.title.text.toString()
        val subTitle = binding.subject.text.toString()
        val edtNotes = binding.notes.text.toString()
        val d = Date()
        val dateNotes: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val notes = Notes(null, title = title, subtitle = subTitle, notes = edtNotes, date = dateNotes.toString(), priority)
        viewModelVar.addNotes(notes)

        Toast.makeText(context, "Notes Created Successfully", Toast.LENGTH_SHORT).show()

    }

}