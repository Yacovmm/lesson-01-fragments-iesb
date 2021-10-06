package com.example.aulafragment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aulafragment.fragments.FirstFragment
import com.example.aulafragment.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    lateinit var btnFragment1: Button
    lateinit var btnFragment2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
    }

    private fun bindViews() {
        btnFragment1 = findViewById(R.id.btn_fragment1)
        btnFragment2 = findViewById(R.id.btn_fragment2)

        btnFragment1.setOnClickListener {

            val firstFragment = FirstFragment.newInstance()

            firstFragment.disableActivityBtnCB = {
                btnFragment2.isEnabled = false
            }

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container_fragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            val alreadyExist = supportFragmentManager.fragments.lastOrNull { fragment ->
                fragment.javaClass == SecondFragment::class.java
            }

            if (alreadyExist != null) return@setOnClickListener

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container_fragment, SecondFragment.newInstance("Teste second"))
                addToBackStack(null)
                commit()
            }
        }
    }
}
