package com.example.introkotlin904.TemasKotlin

fun main(){
    while(true) {
        println("Calculadora")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")

        print("Elige opcion: ")
        val opcion = readln().toInt()

        if(opcion == 5)break

        if(opcion !in 1..5){
            println("Opcion incorrecta")
            continue
        }

        print("Por favor ingresa tu numero 1: ")
        val num1 = readln().toDouble()

        print("Por favor ingresa tu numero 2: ")
        val num2 = readln().toDouble()


        val suma = num1 + num2

        val resta = num1 - num2

        val multiplicacion = num1 * num2

        val division = num1 / num2


        when(opcion) {
            1 -> println("Resultado de tu suma es $suma ")
            2 -> println("Resultado de tu resta es $resta")
            3 -> println("Resultado de tu multiplicacion es $multiplicacion")
            4 -> println("Resultado de tu division es $division")
            else -> println("Opcion incorrecta")
        }
    }

    println("Programa cerrado")
}
