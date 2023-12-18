package kg.auca.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class DateTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time)

        val text: TextView = findViewById(R.id.dateTime)
        val time = intent.getStringExtra("dateTime");
        text.text = time
    }

    fun mainScreen(View: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}