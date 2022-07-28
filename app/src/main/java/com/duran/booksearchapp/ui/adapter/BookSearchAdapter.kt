package com.duran.booksearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.duran.booksearchapp.data.model.Book
import com.duran.booksearchapp.databinding.ItemBookPreviewBinding

class BookSearchAdapter : ListAdapter<Book, BookSearchViewHolder>(BookDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchViewHolder {
        return BookSearchViewHolder(
            ItemBookPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    // data를 binding
    override fun onBindViewHolder(holder: BookSearchViewHolder, position: Int) {
        val book = currentList[position]
        holder.bind(book)
    }

    // DiffUtil 작동을 위한 callback
    companion object {
        private val BookDiffCallback = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }
        }
    }
}