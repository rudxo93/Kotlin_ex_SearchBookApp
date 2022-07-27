package com.duran.booksearchapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Book(
    @field:Json(name = "authors")
    val authors: List<String>, // "우재남", "박길식"
    @field:Json(name = "contents")
    val contents: String, // "실습 단계별 명쾌한 멘토링! 대학이나 IT 전문 학원의 안드로이드 프로그래밍 과목 수강생을 대상으로 합니다. 기본적인 프로그래밍을 접해본 독자라면 안드로이드에 꼭 필요한 Java 기초부터 안드로이드 앱 개발까지 학습 가능하도록 구성되어 있습니다. 안드로이드 프로그래밍을 하면서 부딪힐 수 있는 다양한 오류나 실수까지 친절하게 안내하여 시행착오 없이 안드로이드를 빠르게 정복할 수 있습니다.  ※ 본 도서는 대학 강의용 교재로 개발되었으므로 연습문제 해답"
    @field:Json(name = "datetime")
    val datetime: String, // "2022-01-22T00:00:00.000+09:00"
    @field:Json(name = "isbn")
    val isbn: String, // "1156645840 9791156645849"
    @field:Json(name = "price")
    val price: Int, // 33000
    @field:Json(name = "publisher")
    val publisher: String, // "한빛아카데미"
    @field:Json(name = "sale_price")
    val salePrice: Int, // 32010
    @field:Json(name = "status")
    val status: String, // "정상판매"
    @field:Json(name = "thumbnail")
    val thumbnail: String, // "https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5958356%3Ftimestamp%3D20220726174821"
    @field:Json(name = "title")
    val title: String, // "Android Studio를 활용한 안드로이드 프로그래밍(7판)(IT CookBook)"
    @field:Json(name = "translators")
    val translators: List<Any>, // []
    @field:Json(name = "url")
    val url: String // "https://search.daum.net/search?w=bookpage&bookId=5958356&q=Android+Studio%EB%A5%BC+%ED%99%9C%EC%9A%A9%ED%95%9C+%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C+%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%287%ED%8C%90%29%28IT+CookBook%29"
)