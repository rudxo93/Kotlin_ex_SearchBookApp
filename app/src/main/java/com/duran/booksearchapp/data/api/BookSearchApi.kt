package com.duran.booksearchapp.data.api

import com.duran.booksearchapp.data.model.SearchResponse
import com.duran.booksearchapp.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// 레트로핏은 httpApi의 request를 인터페이스로 정의해서 사용한다.
interface BookSearchApi {

    // 인증에 필요한 Headers 정의
    @Headers("Authorization: KakaoAK $API_KEY")
    // get요청에 필요한 주소
    @GET("v3/search/book")
    // 인터페이스의 메서드인 searchBooks는 SearchResponse타입을 가지는 Response클래스를 반환하도록 정의하면 된다.
    suspend fun searchBooks(
        // Query 어노테이션을 사용해서 전달한다.
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<SearchResponse>
}