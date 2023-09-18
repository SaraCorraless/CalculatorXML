package com.scs.calculatorxml

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.coroutines.selects.select
import java.security.AccessController.getContext

@SuppressLint("AppCompatCustomView")
class MyKeyboard(context: Context?)  {

    //var buttonId = 0
    private var contextLocal = context
    var operacion = ""
    var digitsClick = 2
    var dig1:Int = 0
    var dig2:Int = 0
    var ope:String = ""
    var widthButton = 0
    var heightButton = 0
    var colorButton = Color.GRAY
    var textButton = "test"
    val arrayKeycapes = arrayOf<String>(
          "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "", "0", "", "x"
        //0    1    2    3    4    5     6    7   8    9    10   11  12   13  14   15
    )


    fun createKayboard(keyboard : LinearLayout, resultText: TextView){


        keyboard.setOrientation(LinearLayout.VERTICAL)
        keyboard.setGravity(Gravity.CENTER)

        var count = 0

        //botones numéricos
        for (i in 0 .. 3){
            val fila = createRow(Gravity.CENTER, LinearLayout.HORIZONTAL)

            for (j in 0 .. 3){
                count++

                if (count == 13 || count == 15){
                    fila.addView(createButton(250, 250, "", Color.CYAN, false, resultText))
                }else{
                    fila.addView(createButton(250, 250, arrayKeycapes[count-1], Color.DKGRAY, true, resultText))
                }
                println(count)
            }
            keyboard.addView(fila)



        }

        val fila = createRow(Gravity.CENTER, LinearLayout.HORIZONTAL)


        fila.addView(createButton(250, 1200, "RESULTADO", Color.DKGRAY, true, resultText))


        keyboard.addView(fila)
    }



    fun createButton(height: Int, width: Int, text: String, color : Int, click : Boolean, resultText: TextView): Button{
        val button = Button(contextLocal)
        button.setText(text)
        button.setHeight(height)
        button.setWidth(width)
        button.setBackgroundColor(color)
        button.setEnabled(click)
        //button.id = button.getText()

        actionDigits(button, resultText)

        return button
    }

    fun createRow(gravity: Int, orientation: Int): LinearLayout{
        val fila = LinearLayout(contextLocal)
        fila.setOrientation(orientation)
        fila.setGravity(gravity)

        return fila
    }


    fun actionDigits(button: Button, resultText: TextView) {
        button.setOnClickListener {
            /*if(digitsClick >= 0){
                Toast.makeText(contextLocal, button.getText(), Toast.LENGTH_SHORT).show()
                when(digitsClick){
                    2 -> {
                        dig1 = button.getText().toString().toInt()
                        Toast.makeText(contextLocal, "digito1 "+dig1.toString(), Toast.LENGTH_SHORT).show()
                        digitsClick--
                    }

                    1 -> {
                        ope = button.getText().toString()
                        Toast.makeText(contextLocal, "operador "+ ope + ope.isDigitsOnly(), Toast.LENGTH_SHORT).show()
                        digitsClick--
                    }
                    0 -> {
                        dig2 = button.getText().toString().toInt()
                        Toast.makeText(contextLocal, "digito2 "+dig2.toString(), Toast.LENGTH_SHORT).show()
                        digitsClick--

                    }
                }
            }*/

            operacion = operacion + button.getText()
            Toast.makeText(contextLocal, operacion, Toast.LENGTH_SHORT).show()
            var numeros = operacion.split(Regex("[-+x/%^]"))
            Toast.makeText(contextLocal, numeros.toString(), Toast.LENGTH_LONG).show()

            var operadores = operacion.split(Regex("[0-9]"))
            Toast.makeText(contextLocal, operadores.toString(), Toast.LENGTH_LONG).show()
            resultText.setText(operacion)

            //Perfeccionar forma de obtener operadores y números

        }
    }




}