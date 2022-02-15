package com.lopezalex.booknook.books

import android.os.Bundle
import android.provider.ContactsContract
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.lopezalex.booknook.R
import com.lopezalex.booknook.databinding.BookCardBinding
import com.lopezalex.booknook.databinding.BookDetailFragmentBinding
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

        setHasOptionsMenu(true)

        return binding.root
    }


    private fun addViewForBook(book: Book) {

        var bookLayoutBinding = DataBindingUtil.inflate<BookCardBinding>(layoutInflater, R.layout.book_card, binding.bookListLinearLayout, false)
        bookLayoutBinding.book = book
        bookLayoutBinding.notifyChange()
        binding.bookListLinearLayout.addView(bookLayoutBinding.root)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.loginFragment ->
                findNavController().navigate(BookListFragmentDirections.actionBookListDestinationToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }


}