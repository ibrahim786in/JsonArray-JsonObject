package com.example.ibrahim.serverdatahandlingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_new_json_task.*
import org.json.JSONObject

class NewJsonTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_json_task)

        val jsonString = "{\n" +
                "\t\"name\": \"Mirza\",\n" +
                "\t\"groups\": [{\n" +
                "\t\"name\": \"CP\",\n" +
                "\t\"type\": \"What's App\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\"name\": \"UK\",\n" +
                "\t\"type\": \"Insta\"\n" +
                "\t}\n" +
                "\t]\n}"

        val jsonObj1 = JSONObject(jsonString)
        val name1 = jsonObj1.getString("name")

        nameFromJson.text = name1.toString()

        val jsonArray = jsonObj1.getJSONArray("groups")
        var string = ""
        for (i in 0 until jsonArray.length()) {

            val jsonObject2 = jsonArray.getJSONObject(i)
            val name2 = jsonObject2.getString("name")
            val type = jsonObject2.getString("type")
            string += "name:$name2\ntype:$type\n\n"
            Log.i("NewJSon", string)
            newJsonArray.text = string
        }
    }
}

