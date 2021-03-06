package com.example.ibrahim.serverdatahandlingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_text_auto_complete.*

class TextAutoComplete : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_auto_complete)

        val values=resources.getStringArray(R.array.countries)

//        For Dynamic adding the list in Text AutoComplete
        /* val values= mutableListOf<String>()
        values.add("India")
        values.add("Indonesia")
        values.add("Saudi Arabia")
        values.add("Iceland")
       */

        val adapter=ArrayAdapter<String>(this@TextAutoComplete,
                R.layout.textviewdesign,values)
        autoComplTV.setAdapter(adapter)
        autoComplTV.threshold=1

    }
}
