package com.example.todolist.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.APP
import com.example.todolist.R
import com.example.todolist.databinding.FragmentDetailsBinding
import com.example.todolist.model.NoteModel


class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDetailsFragment()
    }

    private fun initDetailsFragment() {
        val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.titleDetails.text = currentNote.title
        binding.detailsDescription.text = currentNote.description

        binding.deleteButton.setOnClickListener {
            viewModel.delete(currentNote) {}
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }

        binding.backButton.setOnClickListener {
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
    }

//    companion object {
//
//        @JvmStatic
//        fun newInstance() = DetailsFragment()
//    }
}