package com.example.bottomnavigationviewpractice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    // 총 아이템의 개수
    override fun getItemCount(): Int = 3
    // position 에 따라서 어떤 fragment 를 보여줄지 설정
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }
}