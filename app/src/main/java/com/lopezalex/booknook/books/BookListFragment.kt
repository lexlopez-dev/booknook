package com.lopezalex.booknook.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.lopezalex.booknook.R
import com.lopezalex.booknook.databinding.BookListFragmentBinding
import com.lopezalex.booknook.models.Book
import com.lopezalex.booknook.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.book_card.view.*
import kotlinx.android.synthetic.main.book_list_fragment.*
import timber.log.Timber

class BookListFragment : Fragment() {


    private val viewModel: BookViewModel by activityViewModels()

    private val binding by lazy {
        BookListFragmentBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        Timber.i("Called ViewModelProvider")
        binding.lifecycleOwner = this

        viewModel.books.observe(viewLifecycleOwner) { bookList ->
            binding.bookListLinearLayout.removeAllViews()
            for (book in bookList) {
                Timber.i("Book = ${book.name}")
                addViewForBook(book)
            }

        }

        binding.bookAddFab.setOnClickListener { findNavController().navigate(BookListFragmentDirections.actionBookListDestinationToBookDetailFragment()) }


        return binding.root
    }


    private fun addViewForBook(book: Book) {

        Timber.i("In addViewForBook")
        Timber.i("Book name = ${book.name}")
        val view = layoutInflater.inflate(R.layout.book_card, null)
        view.bookNameDisplay.text = book.name
        view.bookAuthorDisplay.text = book.author
        view.bookDescriptionDisplay.text = book.description
        view.bookPageDisplay.text = book.pages

        binding.bookListLinearLayout.addView(view)

    }
}