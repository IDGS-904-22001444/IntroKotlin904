package com.example.introkotlin904.TemasKotlin

/*
List
Mutable
Set
MutableSet
Map
MutableMap



val redOnlyFiguras = listOf("Cuadrado", "Triangulo", "Circulo")
    println(redOnlyFiguras)




var figura: mutableFiguras = mutableListOf("cuadrado", "Triangulo", "Circulo")
val redOnlyFiguras = listOf("Cuadrado", "Triangulo", "Circulo")
val mutableFiguras  :List<String> = figura


val frutas = setOf("Manzana", "banana", "naranja")
val frutas = mutableSetOf("manzana", "banana", "naranja")



val coches=mapOf("uno" to 1, "dos" to 2, "tres" to 3)
println(coches)
        val coches2= mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
println(coches2)

        */

fun main(){
    val readOnlyFiguras= listOf("cuadrado", "triangulo", "circulo")
    println(readOnlyFiguras)
    println("La primera figura es ${readOnlyFiguras[0]}")
    println("El primero elemento es ${readOnlyFiguras.first()}")
    println("numero de elementos ${readOnlyFiguras.count()}items")
    println("circulo" in readOnlyFiguras)
    println(readOnlyFiguras)
    // readOnlyFiguras.add("Pentagono")
    var figura: MutableList<String> = mutableListOf("cuadrado2", "triangulo2", "circulo2")
    println(figura)
    figura.add("pentagono2")
    println(figura)
    figura.remove("cuadrado2")
    println(figura)


}