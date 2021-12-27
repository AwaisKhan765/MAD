package com.example.fetchdatafrom_api_lab_terminal_part

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.HurlStack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appnetwork = BasicNetwork(HurlStack())
        val appcache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
        requestQueue = RequestQueue(appcache, appnetwork).apply {
            start()
        }
        search.setOnClickListener {
            var input = userinput.text.toString()
            fetchData(input)
        }
        fun fetchData( input: String){
            val url = "https://run.mocky.io/v3/0085e3ac-c7d6-4a93-ba92-925f65be6fb3"
            val jsonObjectRequest = JsonObjectRequest(
                DownloadManager.Request.Method.GET, url, null,
                { response ->
                    if(response.get("Response")=="False"){
                        name.text = "Incorrect detail"
                    }else {

                        plot.text = response.getString("ploot")
                        name.text = response.getString("Title")+"\n\n"+"Writer: "+response.getString("Writer")
                    }
                },
                { error ->
                    Log.d("vol",error.toString())
                }
            )

            requestQueue.add(jsonObjectRequest)
        }

    }
}