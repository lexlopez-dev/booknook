package com.lopezalex.booknook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lopezalex.booknook.models.Book
import timber.log.Timber

class BookViewModel : ViewModel() {

    // Current Books
    private var _books =  MutableLiveData<MutableList<Book>>()
    val books : LiveData<MutableList<Book>>
        get() = _books

    //Temp data holders to determine if new book needs to be added
    var name = ""
    var author= ""
    var description = ""
    var pages = ""

    init {
        _books.value = mutableListOf()
        Timber.i("BooksListViewModel created")

    }

    fun addNewBook() {
        addBook(name, author, description, pages)
    }

    private fun addBook(name: String, author: String, description: String, pages: String) {
        val newBook = Book(name, pages, author, description)
        _books.value!!.add(newBook)
    }

    fun resetBook() {
        name = ""
        author = ""
        description = ""
        pages = ""
    }


}