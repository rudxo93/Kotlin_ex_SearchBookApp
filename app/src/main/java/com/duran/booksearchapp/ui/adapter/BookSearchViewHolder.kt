package com.duran.booksearchapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.duran.booksearchapp.data.model.Book
import com.duran.booksearchapp.databinding.ItemBookPreviewBinding

class BookSearchViewHolder(
    private val binding: ItemBookPreviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Book) {
        // list형식이기 때문에 좌우에 []를 삭제
        val author = book.authors.toString().removeSurrounding("[", "]")
        val publisher = book.publisher
        // date는 null이 들어올수도 있기 때문에 book.datetime.isNotEmpty() 방어적 코딩
        // date의 경우 2022-01-22T00:00:00.000+09:00중에서 날짜가 2022-01-22만 필요하기 때문에 10자리까지만 가져오도록 했다.
        // 값이 없을경우 공백
        val date = if (book.datetime.isNotEmpty()) book.datetime.substring(0, 10) else ""

        // 각각의 view와 data들을 binding
        itemView.apply {
            binding.ivArticleImage.load(book.thumbnail)
            binding.tvTitle.text = book.title
            binding.tvAuthor.text = "$author | $publisher"
            binding.tvDatetime.text = date
        }
    }
}