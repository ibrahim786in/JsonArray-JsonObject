package com.example.ibrahim.serverdatahandlingapp

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL




class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var line: String
        var data = ""
        AsyncTask.execute {
            val url = URL("https://jsonplaceholder.typicode.com/todos/1")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            val sBuilder = StringBuilder()

            try {
                httpURLConnection.requestMethod = "GET"
                val inputStream = BufferedInputStream(httpURLConnection.inputStream)
                val reader = BufferedReader(InputStreamReader(inputStream))

                reader.forEachLine {
                    line = reader.readLine()
                    data += line

                    sBuilder.append(line + "\n")
                }
                /*reader.readLine().forEach {
                    line=reader.readLine()
                    sBuilder.append(line +"\n")
                }*/

                Log.i(tag, sBuilder.toString())
                val jsonObject = JSONObject(data)
                userID.text = jsonObject.getString("userId")
                title1.text = jsonObject.getString("title")


            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                httpURLConnection.disconnect()
            }
        }
    }
}
