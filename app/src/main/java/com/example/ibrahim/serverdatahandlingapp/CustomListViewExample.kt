package com.example.ibrahim.serverdatahandlingapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
import java.io.File

class CustomListViewExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_example)
        val permisStatus = ContextCompat.checkSelfPermission(this@CustomListViewExample, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (permisStatus == PackageManager.PERMISSION_GRANTED) readFile()
        else ActivityCompat.requestPermissions(this@CustomListViewExample, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET),7007)



   val inflater=LayoutInflater.from(this@CustomListViewExample)
//    val viewInf=inflater.inflate(R.layout.custominflaterlayout)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults[0]== PackageManager.PERMISSION_GRANTED) readFile()
        else Toast.makeText(this@CustomListViewExample,"The Permission is denied", Toast.LENGTH_LONG).show()
    }

    private fun readFile() {
        var path = "/storage/sdcard0/"
        var file = File(path)
        if (!file.exists()) {
            path = "/storage/emulated/0/"
            file = File(path)
        }

        val files = file.listFiles() //Array String of files
//        val adapter = ArrayAdapter<Files>(this@CustomListViewExample, R.layout.custominflaterlayout, files)
//        simpleListView.adapter = MyCustomAdapter()

    }
}