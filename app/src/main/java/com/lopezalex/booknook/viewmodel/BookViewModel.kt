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
        mockBooks()

    }

    private fun mockBooks() {
        addBook("The Lord Of The Rings", "J. R. R. Tolkien", "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them", "1216")
        addBook("The Hunger Games", "Suzanne Collins","In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. " ,"374")
        addBook("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Harry has a lot on his mind for this, his fifth year at Hogwarts: a Defense Against the Dark Arts teacher with a personality like poisoned honey; a big surprise on the Gryffindor Quidditch team; and the looming terror of the Ordinary Wizarding Level exams. But all these things pale next to the growing threat of He-Who-Must-Not-Be-Named - a threat that neither the magical government nor the authorities at Hogwarts can stop.", "870")
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