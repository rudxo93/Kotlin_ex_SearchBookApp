package com.duran.booksearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duran.booksearchapp.databinding.ActivityMainBinding
import com.duran.booksearchapp.ui.view.FavoriteFragment
import com.duran.booksearchapp.ui.view.SearchFragment
import com.duran.booksearchapp.ui.view.SettingFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 하단의 아이템들을 클릭했을때 화면전환 구현
        setupBottomNavigationView()

        // 앱이 처음 실행되었을 때 -> SearchFragment를 화면에 띄운다.
        if (savedInstanceState == null) { // savedInstanceState -> 앱이 처음 실행되었는지 여부를 판단
            binding.bottomNavigationView.selectedItemId = R.id.fragment_search
        }
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