package com.example.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexample.databinding.Fragment2Binding
import com.example.fragmentexample.databinding.Fragment3Binding

class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(layoutInflater)
        return binding.root
    }
}