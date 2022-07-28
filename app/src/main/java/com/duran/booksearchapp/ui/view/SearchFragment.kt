package com.duran.booksearchapp.ui.view

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.duran.booksearchapp.databinding.FragmentSearchBinding
import com.duran.booksearchapp.ui.adapter.BookSearchAdapter
import com.duran.booksearchapp.ui.viewmodel.BookSearchViewModel
import com.duran.booksearchapp.util.Constants.SEARCH_BOOKS_TIME_DELAY

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookSearchViewModel: BookSearchViewModel
    private lateinit var bookSearchAdapter: BookSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookSearchViewModel = (activity as MainActivity).bookSearchViewModel

        setupRecyclerView()
        searchBooks()

        // searchResult값을 searchFragment에서 감시
        bookSearchViewModel.searchResult.observe(viewLifecycleOwner) { response ->
            val books = response.documents
            bookSearchAdapter.submitList(books)
        }

    }

    private fun setupRecyclerView() {
        bookSearchAdapter = BookSearchAdapter()
        binding.rvSearchResult.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = bookSearchAdapter
        }
    }

    private fun searchBooks() {
        var startTime = System.currentTimeMillis()
        var endTime: Long

        // editText는 addTextChangedListener를 붙혀서 text가 입력이 되면 그 값을 viewModel로 전달한 다음
        // viewModel의 searchBooks가 실행되도록 한다.
        // 이때 값이 입력되자마자 실행하지 않고 사람의 입력시간을 고려해서 검색실행까지 딜레이를 주도록한다.
        binding.etSearch.addTextChangedListener { text: Editable? ->
            endTime = System.currentTimeMillis()
            // 처음 입력과 두번째 입력 사이의 시간이 100L을 넘으면 동작이 수행된다.
            // 그것보다 짧다면 searchBooks가 수행되지 않는다.
            if (endTime - startTime >= SEARCH_BOOKS_TIME_DELAY) {
                text?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty()) {
                        bookSearchViewModel.searchBooks(query)
                    }
                }
            }
            startTime = endTime
        }
    }

    override fun onDestroyView() {
        // 필요없을경우 null처리
        _binding = null
        super.onDestroyView()
    }
}