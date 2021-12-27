package com.example.recyleview2

import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class volley {
    val textView = findViewById<TextView>(R.id.text)


    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(this)
    val url = "https://run.mocky.io/v3/0085e3ac-c7d6-4a93-ba92-925f65be6fb3"


    val stringRequest = StringRequest(
        Request.Method.GET, url,
        Response.Listener<String> { response ->
            // Display the first 500 characters of the response string.
            textView.text = "Response is: ${response.substring(0, 500)}"
        },
        Response.ErrorListener { textView.text = "not working" })
    val TAG = "MyTag"
    val stringRequest: StringRequest
    val requestQueue: RequestQueue?


    stringRequest.tag = TAG

// Add the request to the RequestQueue.
    requestQueue?.add(stringRequest)


    queue.add(stringRequest)
}