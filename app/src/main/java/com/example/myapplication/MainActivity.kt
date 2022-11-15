 package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttons = arrayListOf<ToggleButton>(findViewById(R.id.toggleButton_1),findViewById(R.id.toggleButton_2),findViewById(R.id.toggleButton_3),findViewById(R.id.toggleButton_4),
            findViewById(R.id.toggleButton_5),findViewById(R.id.toggleButton_6),findViewById(R.id.toggleButton_7),findViewById(R.id.toggleButton_8),findViewById(R.id.toggleButton_9))

        var kolejnosc = arrayListOf<Int>(3,5,1,2,6,4,9,7,8)

        //Toast.makeText(this, buttons[0].id.toString().contains("1").toString(), Toast.LENGTH_SHORT).show()

        var nrKlik = 0
        var nrButton = 0

        for (i in buttons.indices)
        {
            buttons[i].setOnClickListener {
                nrButton = buttons[i].text.toString().toInt()
                if (kolejnosc[nrKlik] == nrButton)
                    nrKlik++
                else
                    Toast.makeText(this, "Błąd!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}