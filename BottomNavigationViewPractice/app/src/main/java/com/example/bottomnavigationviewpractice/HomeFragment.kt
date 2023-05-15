package com.example.bottomnavigationviewpractice
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewpractice.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // fragment view 생성이 된 후 viewPager2 setting
        val pageAdapter = PageAdapter(this)
        binding.vpHome.adapter = pageAdapter

        val tabTitleArray = arrayOf(
            "One",
            "Two",
            "Three",
        )
        TabLayoutMediator(binding.tabHome, binding.vpHome) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}