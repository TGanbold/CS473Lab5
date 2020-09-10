package com.example.lab5

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var complete = "0";
    @RequiresApi(Build.VERSION_CODES.O)
    val currentDateTime = LocalDateTime.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit.setOnClickListener {
            if (radioButton2.isChecked) {
                complete = "50%"
            }
            if (checkBox2.isChecked) {
                    complete = "50%"
            }
            if (radioButton2.isChecked && checkBox2.isChecked) {
                    complete = "100%"
            }
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Congrats!" + currentDateTime + "score: " + complete)
            builder.setMessage("Do you want to Exit")
            builder.setPositiveButton("Yes") { dialogInterface, which ->
                dialogInterface.dismiss()
                finish()
            }
            builder.setNegativeButton("Cancel") { dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        reset.setOnClickListener {
            if (radio_group.checkedRadioButtonId != -1) {
                radioButton1.isChecked = false
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                radioButton4.isChecked = false
            }
            if(checkBox1.isChecked || checkBox2.isChecked || checkBox3.isChecked || checkBox4.isChecked) {
                checkBox1.isChecked = false
                checkBox2.isChecked = false
                checkBox3.isChecked = false
                checkBox4.isChecked = false
            }
            Toast.makeText(
                applicationContext, "On click : RESET clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    fun radio_button_click(view: View) {
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(
            applicationContext, "On click : ${radio.text}",
            Toast.LENGTH_SHORT
        ).show()
    }
}






