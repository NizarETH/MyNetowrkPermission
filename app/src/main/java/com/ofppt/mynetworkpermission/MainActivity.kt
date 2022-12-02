package com.ofppt.mynetworkpermission

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>( R.id.open_web).setOnClickListener {

// Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://gist.githubusercontent.com/NizarETH/4bdd464f3e5d026057fbcac960b85a5c/raw/40485eceefc6f938ec1558d4512d2f301f42f306/"

// Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
               Toast.makeText(this@MainActivity, "Response is: ${response.substring(0, 500)}", Toast.LENGTH_LONG).show()
                },
                Response.ErrorListener {

                    Toast.makeText(this@MainActivity, "That didn't work!", Toast.LENGTH_LONG).show()

                })

// Add the request to the RequestQueue.
            queue.add(stringRequest)
         }
    }


}