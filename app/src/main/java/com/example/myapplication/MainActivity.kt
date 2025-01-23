package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val newFragment: Fragment = ItemFragment()
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.add(android.R.id.content, newFragment).commit()
        }
    }
}

