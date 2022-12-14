package com.duran.booksearchapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.duran.booksearchapp.R
import com.duran.booksearchapp.data.repository.BookSearchRepositoryImpl
import com.duran.booksearchapp.databinding.ActivityMainBinding
import com.duran.booksearchapp.ui.viewmodel.BookSearchViewModel
import com.duran.booksearchapp.ui.viewmodel.BookSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var bookSearchViewModel: BookSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 하단의 아이템들을 클릭했을때 화면전환 구현
        setupBottomNavigationView()

        // 앱이 처음 실행되었을 때 -> SearchFragment를 화면에 띄운다.
        if (savedInstanceState == null) { // savedInstanceState -> 앱이 처음 실행되었는지 여부를 판단
            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
        }

        // viewModel 초기화
        val bookSearchRepository = BookSearchRepositoryImpl()
        val factory = BookSearchViewModelProviderFactory(bookSearchRepository, this)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SearchFragment())
                        .commit()
                    true
                }

                R.id.fragment_favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, FavoriteFragment())
                        .commit()
                    true
                }

                R.id.fragment_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, SettingFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}