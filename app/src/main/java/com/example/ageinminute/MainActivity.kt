package com.example.ageinminute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var selectDate = findViewById<Button>(R.id.selectDate)
        selectDate.setOnClickListener {view ->
            datePicker(view)
            Toast.makeText(this,"Button Pressed", Toast.LENGTH_SHORT).show() }

    }
    fun datePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        var selectedDate = findViewById<TextView>(R.id.selectedDate)
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                val Datess ="$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                selectedDate.setText(Datess)
                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate = sdf.parse(Datess)

        }
            ,year
            ,month
            ,day).show()
    }
    
}