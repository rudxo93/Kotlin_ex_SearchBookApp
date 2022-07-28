package com.duran.booksearchapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    // Json만으로는 Kotlin에서 변환에 실패하기 때문에 앞에 field를 붙혀준다.
    @field:Json(name = "is_end")
    val isEnd: Boolean,
    @field:Json(name = "pageable_count")
    val pageableCount: Int,
    @field:Json(name = "total_count")
    val totalCount: Int
)