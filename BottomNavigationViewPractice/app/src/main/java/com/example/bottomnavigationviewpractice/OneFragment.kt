package com.example.bottomnavigationviewpractice
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewpractice.databinding.FragmentOneBinding
import com.example.bottomnavigationviewpractice.databinding.FragmentSettingBinding


class OneFragment : Fragment() {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }
}