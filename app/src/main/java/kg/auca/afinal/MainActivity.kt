package kg.auca.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun dateTimeScreen(view: View) {
        val intent = Intent(this, DateTime::class.java)
        val dateTime = Calendar.getInstance();
        val format = SimpleDateFormat("H:m M/d/y ", Locale.getDefault())
        val dateAndTimeWithFormat = format.format(dateTime.time)
        intent.putExtra("dateTime", dateAndTimeWithFormat)
        startActivity(intent)
    }

    fun publicIPScreen(view: View) {
        val intent = Intent(this, MyIp::class.java)
        startActivity(intent)
    }
}