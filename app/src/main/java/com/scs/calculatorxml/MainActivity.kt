package com.scs.calculatorxml


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

        val keyboard = findViewById<LinearLayout>(R.id.keyboard)
        keyboard.setOrientation(LinearLayout.VERTICAL)
        keyboard.setGravity(Gravity.CENTER)
        //crear un teclado en código


        for (i in 0 .. 3){
            val fila = LinearLayout(this)
            fila.setOrientation(LinearLayout.HORIZONTAL)
            fila.setGravity(Gravity.CENTER)

            for (j in 0 .. 3){

                val button = Button(this)
                button.setText("hola"+i)
                button.setHeight(250)
                button.setWidth(250)


                fila.addView(button)

            }
            keyboard.addView(fila)



        }
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