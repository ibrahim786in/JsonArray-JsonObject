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
                "\t\t\t\"name\": \"CP\",\n" +
                "\t\t\t\"type\": \"What's App\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"UK\",\n" +
                "\t\t\t\"type\": \"Insta\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}"
        val jsonObj1 = JSONObject(jsonString)
//        Log.i("NewJSon",jsonObj1.toString())
        val name = jsonObj1.getString("name")
//        val number = jsonObj1.getString("number")
        nameFromJson.text = name.toString()
//        numberFromJson.text = number.toString()

        val jsonArray = jsonObj1.getJSONArray("groups")
        var string = ""
        for (i in 0 until jsonArray.length()) {
            jsonArray.length()
            val jsonObject2 = jsonArray.getJSONObject(i)
            val name = jsonObject2.getString("name")
            val type = jsonObject2.getString("type")
            string += "name:$name\ntype:$type\n\n"
            Log.i("NewJSon", string)
            newJsonArray.text = string
        }


    }



    private fun getStrig() {
        "Mirzaahmedbaig".forEach {
            var string = ""
            string += it.toString()
            Log.d("NewJSon", string)
        }
        //
    }

}
fun main(args:Array<String>){
    "Mirzaahmedbaig".forEach {
        var string = ""
        string += it.toString()
        System.out.print("\n\n"+string)
    }
}