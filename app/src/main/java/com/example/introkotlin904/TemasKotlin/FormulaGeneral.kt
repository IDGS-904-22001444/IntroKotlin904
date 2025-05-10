package com.example.introkotlin904.TemasKotlin

import kotlin.math.sqrt

fun main() {
    while (true) {
        println("Calculadora de fórmula General")
        println("1. Formula General")
        println("2. Salir")

        print("Elige opcion: ")
        val opcion = readln().toIntOrNull()

        if (opcion == 2) break

        if (opcion != 1) {
            println("Opcion invalida")
            continue
        }

        print("Ingresa el valor de a: ")
        val a = readln().toDoubleOrNull()

        print("Ingresa el valor de b: ")
        val b = readln().toDoubleOrNull()

        print("Ingresa el valor de c: ")
        val c = readln().toDoubleOrNull()

        if (a == null || b == null || c == null) {
            println("Entrada invalida. Por favor, ingresa numeros validos.")
            continue
        }

        val numerador = b * b - 4 * a * c

        when {
            numerador > 0 -> {
                val x1 = (-b + sqrt(numerador)) / (2 * a)
                val x2 = (-b - sqrt(numerador)) / (2 * a)
                println("Las soluciones son x1 = $x1 y x2 = $x2")
            }
            numerador == 0.0 -> {
                val x = -b / (2 * a)
                println("La solución es x = $x")
            }
            else -> {
                val parteReal = -b / (2 * a)
                val parteImaginaria = sqrt(-numerador) / (2 * a)
                println("Las soluciones son complejas: x1 = $parteReal + ${parteImaginaria}i y x2 = $parteReal - ${parteImaginaria}i")
            }
        }
    }

    println("Programa finalizado")
}