package com.duran.booksearchapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.duran.booksearchapp.data.repository.BookSearchRepository

@Suppress("UNCHECKED_CAST")
class BookSearchViewModelProviderFactory(
    // bookSearchRepository를 초기값으로 전달받는다.
    private val bookSearchRepository: BookSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            // viewModel을 반환하는 ViewModelProviderFactory를 만들어준다.
            return BookSearchViewModel(bookSearchRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}