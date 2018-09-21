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

            val url = URL("https://jsonplaceholder.typicode.com/todos/1")
            val httpURLConnection = url.openConnection() as HttpURLConnection

            var objUserId=""
            var objId1=""
            var objTitle1=""
            var objComp=""
            try {
                httpURLConnection.requestMethod = "GET"
                val inputStream = BufferedInputStream(httpURLConnection.inputStream)
                val reader = BufferedReader(InputStreamReader(inputStream))

                var data = ""
                var line: String?
                line = reader.readLine()
                while (line != null) {
                    data += line
                    line = reader.readLine()
                }
                    Log.i(tag, data)
                    val jsonObject = JSONObject(data)

                  objUserId = jsonObject.getString("userId")
                  objId1 = jsonObject.getString("id")
                  objTitle1 = jsonObject.getString("title")
                  objComp = jsonObject.getString("completed")



            } catch (e: Exception) {
                e.printStackTrace()
            }
            runOnUiThread {
                userID.text = "User ID: $objUserId"
                id1.text = "ID: $objId1"
                title1.text = "Title :$objTitle1"
                completeOrNot.text = "Process Completed or Not $objComp"
            }
        }

    }
}

