package com.lopezalex.booknook.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.lopezalex.booknook.R
import com.lopezalex.booknook.databinding.InstructionsFragmentBinding


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)

        binding.booksListButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsDestinationToBookListDestination())
        }

        return binding.root
    }


}