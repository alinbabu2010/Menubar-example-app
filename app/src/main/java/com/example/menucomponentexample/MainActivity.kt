package com.example.menucomponentexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonId = findViewById<Button>(R.id.revertButton)
        buttonId.setOnClickListener {
            changeTextColor("#03A9F4")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_green -> {
                changeTextColor("#20880E")
                true
            }
            R.id.menu_orange -> {
                changeTextColor("#FF5900")
                true
            }
            R.id.menu_red -> {
                changeTextColor("#FF0000")
                true
            }
            R.id.menu_violet -> {
                changeTextColor("#FF6200EE")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun changeTextColor(textColor: String) {
        val textId = findViewById<TextView>(R.id.textView)
        textId.setTextColor(Color.parseColor(textColor))
    }
}