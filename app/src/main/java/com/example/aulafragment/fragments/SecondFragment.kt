package com.example.aulafragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aulafragment.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val param: String? = arguments?.getString(ARG_KEY)

        binding?.titleTv?.text = param ?: "Param null"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        val ARG_KEY = "PARAM1_KEY"

        fun newInstance(param1: String): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_KEY, param1)
                }
            }
        }
    }
}
