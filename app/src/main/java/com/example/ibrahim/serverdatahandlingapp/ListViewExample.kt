package com.example.ibrahim.serverdatahandlingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view_example.*
import java.io.File

class ListViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_example)
        var path = "/storage/sdcard0/"
        var file = File(path)
        if (!file.exists()) {
            path="/storage/emulated/0/"
            file = File(path)
        }
        val files = file.list() //Array String of files
        val adapter = ArrayAdapter<String>(this@ListViewExample, R.layout.textviewdesign, files)
        listView.adapter = adapter
    }
}
