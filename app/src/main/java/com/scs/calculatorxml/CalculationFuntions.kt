package com.scs.calculator.utils

import kotlinx.coroutines.selects.select

fun operator(ope: String, num1: Float, num2: Float): Unit{
    when(ope) {
        "+" -> {
            println("Sum")
            sum(num1, num2)
        }
        "-" -> {
            println("Subtract")
            subtract(num1, num2)
        }
        "*" -> {
            println("Multiply")
            multiply(num1, num2)
        }
        "/" -> {
            println("Division")
            division(num1, num2)
        }
    }
}

fun sum(num1: Float, num2: Float): Float {
    return num1.plus(num2)
}

fun subtract(num1: Float, num2: Float): Float {
    return num1.minus(num2)
}

fun multiply(num1: Float, num2: Float): Float {
    return num1.times(num2)
}

fun division(num1: Float, num2: Float): Float {
    return num1.div(num2)
}