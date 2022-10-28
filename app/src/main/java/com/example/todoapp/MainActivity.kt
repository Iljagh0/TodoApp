package com.example.newapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var noteEditText: EditText
    private lateinit var addButton: Button
    private lateinit var notesTextView: TextView

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.init()

        this.registerListeners()

        this.sharedPreferences = getSharedPreferences(name: "MY_SHARED_PREF", Context.MODE_PRIVATE)
        val notes = this.sharedPreferences.getString("NOTES" , "")
        notesTextView.text = notes
    }

    private fun init() {
        noteEditText = findViewById(R.id.noteEditText)
        addButton = findViewById(R.id.buttonAdd)
        notesTextView = findViewById(R.id.notesTextView)
    }

    private fun registerListeners(){
        addButton.setOnClickListener {
            val note = noteEditText.text.toString()
            val notes = notesTextView.text.toString()

            val result = note + "\n" + notes

            notesTextView.text = result

            noteEditText.setText = ("")

            sharedPreferences.edit()
                .putString("NOTES", result)
                .apply()
        }
    }
}