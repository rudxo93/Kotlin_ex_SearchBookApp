package com.duran.booksearchapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duran.booksearchapp.data.model.SearchResponse
import com.duran.booksearchapp.data.repository.BookSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// repository에서 받아온 데이터를 화면에 표시하는 viewModel
class BookSearchViewModel(
    // BookSearchViewModel은 초기값으로 bookSearchRepository를 전달받아야 하는데 viewModel은 그자체로는
    // 생성시에 초기값을 전달받을수 없기 떄문에 팩토리를 만들어 주어야한다.
    private val bookSearchRepository: BookSearchRepository
) : ViewModel() {

    // Api
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    // repository의 searchBooks를 코루틴 내부에서 수행하는 searchBooks함수
    // 코루틴의 백그라운드 작업을 더 용이하게 수행할수 있도록 해준다.
    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        // repository의 searchBooks를 실행하되 파라미터는 query이외에는 모두 고정값으로 전달하도록
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 15)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                // 레트로핏 서비스의 반환값은 MutableLiveData인 _searchResult에 저장을 하고 외부에는 수정할 수 없는 LiveData로
                // 변환한 searchResult를 노출하도록
                _searchResult.postValue(body)
            }
        }
    }
}