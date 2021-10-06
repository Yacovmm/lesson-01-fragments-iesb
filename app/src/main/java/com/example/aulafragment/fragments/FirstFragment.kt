package com.example.aulafragment.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aulafragment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    var binding: FragmentFirstBinding? = null

    var disableActivityBtnCB: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Aqui dentro temos ceterza da view existente

        binding?.titleTv?.text = "Aula de fragments"

        binding?.titleTv?.setOnClickListener {
            disableActivityBtnCB?.invoke()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}
