package com.example.menucomponentexample

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView

/**
 * Activity class that show implemetation of menus
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method creates the options menu
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    /**
     * This method creates the layout fot the activity*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting view and register that view for context menu creation
        val textId: TextView = findViewById(R.id.textView)
        registerForContextMenu(textId)

        // Get the button view and call the function on button click.
        val buttonId = findViewById<Button>(R.id.revertButton)
        buttonId.setOnClickListener {
            changeTextColor("#03A9F4")
        }

    }

    /**
     * This method is used to identify the selected option and executes option functions.
     */
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

    /**
     * This method is used to create context menu on invoking.
     */
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    /**
     * This method is used to identify the selected context menu option and executes option functions.
     */
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

    /**
     * This method is used to set font style of a text view.
     */
    private fun changeTextStyle(style: Int) {
        val textId = findViewById<TextView>(R.id.textView)
        textId.setTypeface(null, style)
    }

    /**
     * This method is used to set font color of a text view.
     */
    private fun changeTextColor(textColor: String) {
        val textId = findViewById<TextView>(R.id.textView)
        textId.setTextColor(Color.parseColor(textColor))
    }
}