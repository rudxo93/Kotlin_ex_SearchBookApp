package com.duran.booksearchapp.data.api

import com.duran.booksearchapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// 여러개의 Retrofit객체가 만들어지면 자원도 낭비되고 통신의 혼선이 발생될수도 있다.
// 그렇기 때문에 여기서는 object와 by lazy키워드를 통해 실제 사용되는 순간이 와야 비로소 만들어지게되고
// 단 하나의 인스턴스만이 만들어지도록 싱글톤으로 구현

object RetrofitInstance {

    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    // 빌드업 패턴을 통해서 retrofit 객체를 만들어 준다.
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            // DTO변환에 사용할 MoshiConverterFactory를 지정
            .addConverterFactory(MoshiConverterFactory.create())
            // 레트로핏 객체를 생성할때 클라이언트 속성을 okHttp인터셉터를 넘겨줘서 Logcat에서 패킷내용을 모니터링
            .client(okHttpClient)
            // baseUrl 전달
            .baseUrl(BASE_URL)
            // build로 객체 생성
            .build()
    }

    val api: BookSearchApi by lazy {
        // BookSearchApi를 만들어주면 api 사용준비 완료
        retrofit.create(BookSearchApi::class.java)
    }

}