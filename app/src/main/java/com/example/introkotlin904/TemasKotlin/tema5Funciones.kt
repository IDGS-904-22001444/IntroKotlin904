package com.example.introkotlin904.TemasKotlin

fun saludo (){
    println("Hola mundo")
}


fun suma (a:Int, b:Int){
    println("La suma de $a + $b es ${a+b}")
}

// El :Int significa que se devuelve un entero
fun resta (a:Int, b:Int):Int{
    return a-b
}

/// Funcion de linea
fun resta2 (a:Int, b:Int):Int = a-b

fun main (){
    saludo()
    suma(2,3)
    println("La resta de 2 y 3 es ${resta(2,3)}")
}


/// Operaciones basicas y mostrar el menu (5 salir) , siempre mostrar el menu
/// Permitir realizar una piramide de asterisco, siempre preguntar el numero despues de mostrar la piramide y cuando se ponga 0 se termine (Do while solamente)
/// Permite realizar el calculo de la formula general (validar raices negativas y divisiones por cero), y pedir los valores de a,b,c si sale 0 entonces vuelva a pedir y si es correcto se termina el programa
/*
*
* *
* **
 */