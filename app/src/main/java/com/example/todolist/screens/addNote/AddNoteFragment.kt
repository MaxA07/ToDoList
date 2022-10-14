package com.example.todolist.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.APP
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddNoteBinding
import com.example.todolist.model.NoteModel


class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAddNote()
    }

    private fun initAddNote() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.addNoteButton.setOnClickListener {
            val title = binding.editTextField
            val description = binding.editTextDescription

            viewModel.insert(NoteModel(title = title.text.toString(),description = description.text.toString())) {}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.backButton.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

//    companion object {
//
//        @JvmStatic
//        fun newInstance() = AddNoteFragment()
//    }
}