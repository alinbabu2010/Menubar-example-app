package com.example.menucomponentexample

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
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

        val textId:TextView = findViewById(R.id.textView)
        registerForContextMenu(textId)

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

    override fun onCreateContextMenu(menu: ContextMenu, v:View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bold -> {
                changeTextStyle(Typeface.BOLD)
                true
            }
            R.id.normal -> {
                changeTextStyle(Typeface.NORMAL)
                true
            }
            R.id.italics -> {
                changeTextStyle(Typeface.ITALIC)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun changeTextStyle(style: Int) {
        val textId = findViewById<TextView>(R.id.textView)
        textId.setTypeface(null,style)
    }


    private fun changeTextColor(textColor: String) {
        val textId = findViewById<TextView>(R.id.textView)
        textId.setTextColor(Color.parseColor(textColor))
    }
}