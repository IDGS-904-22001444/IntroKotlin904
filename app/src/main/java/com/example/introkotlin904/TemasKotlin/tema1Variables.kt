package com.example.introkotlin904.TemasKotlin

fun main(){

    // Variables solo lectura val(similar a una constante)
    // variables mutables var

    val a=4
    val b=8
    var c=10



    print(a)
    println("el valor de b es $b")
    println("el valor de b es ${c+2}")

    c= a+2
    c+=8
    c-=5
    c/=2

    println("el valor de c es $c")

    var num1:Int=23
    var num2:Int=12

    num2= 6

    var nombre:String="Carlos"
    var caracter:Char='a'

    var num4:Float=12.5f
    var num5:Double=12.5


}