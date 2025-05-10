package com.example.introkotlin904.TemasKotlin

fun main() {
    var filas: Int

    do {
        println("Ingresa el numero de filas que quieres que haya en tu piramide (introduce 0 para salir):")
        filas = readLine()?.toIntOrNull() ?: 0



         if (filas > 0) {
            for (i in 1..filas) {
                for (j in 1..(filas - i)) {
                    print(" ")
                }
                for (k in 1..(2 * i - 1)) {
                    print("*")
                }
                println()
            }
        }
        else if (filas < 0) {
            println("Este es un numero negativo, ingresa un numero positivo.")
        }

    } while (filas != 0)

    println("Saliendo del programa.")
}