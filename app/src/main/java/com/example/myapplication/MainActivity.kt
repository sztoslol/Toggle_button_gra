package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import org.w3c.dom.Text
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttons = arrayListOf<ToggleButton>(findViewById(R.id.toggleButton_1),findViewById(R.id.toggleButton_2),findViewById(R.id.toggleButton_3),findViewById(R.id.toggleButton_4),
            findViewById(R.id.toggleButton_5),findViewById(R.id.toggleButton_6),findViewById(R.id.toggleButton_7),findViewById(R.id.toggleButton_8),findViewById(R.id.toggleButton_9))

        var kolejnosc = losuj()

        var nrKlik = 0
        var nrButton = 0
        var punkty = 0

        for (i in buttons.indices)
        {
            buttons[i].setOnClickListener {
                nrButton = buttons[i].text.toString().toInt()
                if (kolejnosc[nrKlik] == nrButton)
                    nrKlik++
                else{
                    nrKlik = 0
                    nrButton = 0
                    for (j in buttons.indices)
                        buttons[j].isChecked = false
                }
                if (nrKlik == 9){
                    for (i in buttons.indices)
                        buttons[i].isChecked = false
                    nrKlik = 0
                    Toast.makeText(this, "Wygrałeś!", Toast.LENGTH_SHORT).show()
                    punkty+=10
                    findViewById<TextView>(R.id.textView_wynik).setText("Wynik: " + punkty.toString())

                    kolejnosc = losuj()
                }
            }
        }
    }
}
    private fun losuj() : List<Int> {
        val kolejnosc = generateSequence {
            Random.nextInt(1..9)
        }.distinct().take(9).toList()
        return kolejnosc
    }