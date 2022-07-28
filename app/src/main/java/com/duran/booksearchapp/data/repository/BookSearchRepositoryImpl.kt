package com.duran.booksearchapp.data.repository

import com.duran.booksearchapp.data.api.RetrofitInstance.api
import com.duran.booksearchapp.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        // 레트로핏 api의 searchbooks를 실행시켜 response를 반환받도록 구현
        return api.searchBooks(query, sort, page, size)
    }
}