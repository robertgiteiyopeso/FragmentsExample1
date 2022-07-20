package com.example.fragmentsexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mbutton = this.findViewById<Button>(R.id.open_button)
        var isFragmentDisplayed = false

        fun displayFragment() {
            val simpleFragment = SimpleFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, simpleFragment, "1")
                addToBackStack(null)
                mbutton.setText(R.string.close)
                isFragmentDisplayed = true
                commit()
            }
        }

        fun closeFragment() {
            val simpleFragment = supportFragmentManager.findFragmentByTag("1") ?: return
            supportFragmentManager.beginTransaction().apply {
                hide(simpleFragment)
                mbutton.setText(R.string.open)
                isFragmentDisplayed = false
                commit()
            }
        }

        mbutton.setOnClickListener {
            if(isFragmentDisplayed){
                closeFragment()
            }
            else {
                displayFragment()
            }
        }
    }


}