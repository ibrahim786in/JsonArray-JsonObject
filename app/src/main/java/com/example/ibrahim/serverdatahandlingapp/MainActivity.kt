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

        AsyncTask.execute {

            var data = ""
            var line: String?
            val url = URL("https://jsonplaceholder.typicode.com/todos/1")
            val httpURLConnection = url.openConnection() as HttpURLConnection

            try {
                httpURLConnection.requestMethod = "GET"
                val inputStream = BufferedInputStream(httpURLConnection.inputStream)
                val reader = BufferedReader(InputStreamReader(inputStream))

                line = reader.readLine()
                while (line != null) {
                    data += line
                    line = reader.readLine()

                    Log.i(tag, data)
                    val jsonObject = JSONObject(data)
//                val jsonObj2 = jsonObject.getJSONObject(data)

                    val objUserId = jsonObject.getString("userId")
                    val objId1 = jsonObject.getString("id")
                    val objTitle1 = jsonObject.getString("title")
                    val objComp = jsonObject.getString("completed")

                    userID.text = "User ID: $objUserId"
                    id1.text = "ID: $objId1"
                    title1.text = "Title :$objTitle1"
                    completeOrNot.text = "Process Completed or Not $objComp"
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

