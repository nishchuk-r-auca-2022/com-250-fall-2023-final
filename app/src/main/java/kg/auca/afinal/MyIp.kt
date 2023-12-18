package kg.auca.afinal

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MyIp : AppCompatActivity() {

    private lateinit var ipAddressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_ip)

        ipAddressTextView = findViewById(R.id.textView2)

        FetchIpTask().execute()
    }

    fun main(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private inner class FetchIpTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void?): String? {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://api.ipify.org?format=json")
                .build()

            try {
                val response = client.newCall(request).execute()
                return response.body?.string()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            result?.let {
                try {
                    val jsonObject = JSONObject(it)
                    val ipAddress = jsonObject.getString("ip")
                    ipAddressTextView.text = ipAddress
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
