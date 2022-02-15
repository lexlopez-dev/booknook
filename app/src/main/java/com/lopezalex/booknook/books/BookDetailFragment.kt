package com.lopezalex.booknook.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.lopezalex.booknook.databinding.BookDetailFragmentBinding
import com.lopezalex.booknook.viewmodel.BookViewModel
import com.lopezalex.booknook.databinding.*


class BookDetailFragment : Fragment() {

    private val viewModel: BookViewModel by activityViewModels()

    private val binding by lazy {
        BookDetailFragmentBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel.resetBook()

        binding.viewModel = viewModel

        binding.saveBtn.setOnClickListener {
            viewModel.addNewBook()

            it.findNavController().navigate(
                BookDetailFragmentDirections.actionBookDetailAddDestinationToBookListDestination()
            )
        }

        binding.cancelBtn.setOnClickListener {
            it.findNavController().navigate(
                BookDetailFragmentDirections.actionBookDetailAddDestinationToBookListDestination()
            )
        }
        binding.lifecycleOwner = this

        return binding.root
    }
}