package com.example.xmlusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"
    private  val BASE_URL = "https://www.ocregister.com/location/california/orange-county/"
    var mylist = arrayListOf<myData>()
    lateinit var rvMain: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedAPI = retrofit.create(FeedAPI::class.java)
        val call = feedAPI.feed


            call!!.enqueue(object : Callback<Feed?> {
                override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {
                    Log.d(TAG, "onResponse: feed: " + response.body().toString())
                    Log.d(TAG, "onResponse: Server Response: $response")
                    val entries = response.body()!!.entrys
                    for (entry in entries!!) {
                        Log.d(TAG, "onResponse: ${entry.content1}")

                        mylist.add(myData(entry.content1.toString(),entry.content2.toString(),entry.content3.toString()))
                        rvMain.adapter?.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Feed?>, t: Throwable) {
                    Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                    Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
                }
            })

        rvMain.adapter = RVAdapter(mylist)
        rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
        rvMain.adapter?.notifyDataSetChanged()
        }

    }


