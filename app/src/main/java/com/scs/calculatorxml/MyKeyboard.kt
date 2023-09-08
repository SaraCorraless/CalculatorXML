package com.scs.calculatorxml

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import java.security.AccessController.getContext

@SuppressLint("AppCompatCustomView")
class MyKeyboard()  {

    var widthButton = 0
    var heightButton = 0
    var colorButton = Color.GRAY
    var textButton = "test"
    val arrayKeycapes = arrayOf<String>(
        "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "", "0", "", "x"
        //   0    1    2    3    4    5     6    7   8    9    10   11  12   13  14   15
    )


    fun createKayboard(context: Context?, keyboard : LinearLayout){


        keyboard.setOrientation(LinearLayout.VERTICAL)
        keyboard.setGravity(Gravity.CENTER)

        var count = 0

        //botones numéricos
        for (i in 0 .. 3){
            val fila = createRow(context, Gravity.CENTER, LinearLayout.HORIZONTAL)

            for (j in 0 .. 3){
                count++

                if (count == 13 || count == 15){


                    fila.addView(createButton(context, 250, 250, "", Color.CYAN, false))


                }else{

                    fila.addView(createButton(context, 250, 250, arrayKeycapes[count-1], Color.DKGRAY, true))

                }



                println(count)
            }
            keyboard.addView(fila)



        }

        val fila = createRow(context, Gravity.CENTER, LinearLayout.HORIZONTAL)


        fila.addView(createButton(context, 250, 1200, "RESULTADO", Color.DKGRAY, true))


        keyboard.addView(fila)
    }



    fun createButton(context: Context?, height: Int, width: Int, text: String, color : Int, click : Boolean): Button{
        val button = Button(context)
        button.setText(text)
        button.setHeight(height)
        button.setWidth(width)
        button.setBackgroundColor(color)
        button.setEnabled(click)

        return button
    }

    fun createRow(context: Context?, gravity: Int, orientation: Int): LinearLayout{
        val fila = LinearLayout(context)
        fila.setOrientation(orientation)
        fila.setGravity(gravity)

        return fila
    }

}