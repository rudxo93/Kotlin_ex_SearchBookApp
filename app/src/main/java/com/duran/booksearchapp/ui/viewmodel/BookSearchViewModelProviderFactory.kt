package com.duran.booksearchapp.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.duran.booksearchapp.data.repository.BookSearchRepository

@Suppress("UNCHECKED_CAST")
/*
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
}*/

class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository,
    // SavedStateRegistryOwner를 mainActivity로 전달
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository, handle) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}