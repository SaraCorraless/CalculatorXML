package com.scs.calculatorxml


import android.graphics.Color
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))


        createKayboard()

    }

    fun createKayboard(){
        val arrayKeycapes = arrayOf<String>(
            "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "", "0", "", "x"
        //   0    1    2    3    4    5     6    7   8    9    10   11  12   13  14   15
        )


        val keyboard = findViewById<LinearLayout>(R.id.keyboard)
        keyboard.setOrientation(LinearLayout.VERTICAL)
        keyboard.setGravity(Gravity.CENTER)

        var count = 0

        //botones numéricos
        for (i in 0 .. 3){
            val fila = LinearLayout(this)
            fila.setOrientation(LinearLayout.HORIZONTAL)
            fila.setGravity(Gravity.CENTER)

            for (j in 0 .. 3){
                count++
                val button = Button(this)
                if (count == 13 || count == 15){

                    button.setText("")
                    button.setHeight(250)
                    button.setWidth(250)
                    button.setBackgroundColor(Color.TRANSPARENT)
                    button.setEnabled(false)

                }else{


                    button.setText(arrayKeycapes[count-1])
                    button.setHeight(250)
                    button.setWidth(250)
                }



                fila.addView(button)


                println(count)
            }
            keyboard.addView(fila)



        }

        //botón de resultado
        val fila = LinearLayout(this)
        fila.setOrientation(LinearLayout.HORIZONTAL)
        fila.setGravity(Gravity.CENTER)

        val buttonResult = Button(this)
        buttonResult.setText("RESULTADO")
        buttonResult.setHeight(250)
        buttonResult.setWidth(1500)


        fila.addView(buttonResult)
        keyboard.addView(fila)




    }
}