package kg.auca.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.net.URL

class MyIp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_ip)
        val text: TextView = findViewById(R.id.textView2)
        text.text = "Hello"
    }

    fun main(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}