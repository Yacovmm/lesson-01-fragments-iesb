package com.example.aulafragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aulafragment.R

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {

        val ARG_KEY = "PARAM1_KEY"

        fun newInstance(param1: String): FirstFragment {
            return FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY, param1)
                }
            }
        }
    }
}
