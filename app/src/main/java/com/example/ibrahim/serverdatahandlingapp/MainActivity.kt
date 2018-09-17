package com.example.ibrahim.serverdatahandlingapp

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL




class MainActivity : AppCompatActivity() {
private val tag="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AsyncTask.execute {
            val url = URL("https://jsonplaceholder.typicode.com/todos/1")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            try {
                httpURLConnection.requestMethod = "GET"
                val inputStream =BufferedInputStream(httpURLConnection.inputStream)
                val inputString=StringBuffer()
                val inputStreamReader = BufferedReader(InputStreamReader(inputStream))

                val data=inputStreamReader.read()
//                var jString: String? =null
//                val jsonObject = JSONObject(jString)
//                jString=
                inputStreamReader.forEachLine{
                    Log.d(tag,it)
                    inputString.append(it +"\n")
                    Log.d(tag,inputString.toString())

                }
//                val sys = jsonObject.getJSONObject("sys")

                 id1.text = inputString.toString()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                httpURLConnection.disconnect()
            }
        }
    }
}
