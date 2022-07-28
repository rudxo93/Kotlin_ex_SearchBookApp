package com.duran.booksearchapp.util

import com.duran.booksearchapp.BuildConfig

// request요청에 사용할 url과 API키정보를 저장
object Constants {
    const val BASE_URL = "https://dapi.kakao.com/"
    const val API_KEY = BuildConfig.bookApiKey
    // api키를 전역변수로 만들어놓고 사용하게되면 편하긴 하지만 모든사람에게 노출되어버린다...
    // android gradle plugin 7.0.2버전 이상을 사용하는 프로젝트에서는 Secrets Gradle Plugin for Android라는
    // 플러그인을 사용해서 안전하게 키를 주입할 수 있다.
    // https://developers.google.com/maps/documentation/android-sdk/secrets-gradle-plugin 참고

    const val SEARCH_BOOKS_TIME_DELAY = 100L
}