package com.example.ibrahim.serverdatahandlingapp

class ControlFlow

fun main(args: Array<String>) {

    val list = ArrayList<String>()
    list.add("Ibrahim")
    list.add("Shafiq")
    list.add("Mirza")
    var int = 0
    for (i in list) println("1$i\n")
    /*Output:
    Ibrahim
    Shafiq
    Mirza */

    for (i in list.indices) println("\n${list[i]}")
    //Same Output As Above

    list.forEach { _ ->
        println(list[int])
        int++
    }

    while (int < list.size) {
        println(list[int])
        int++
    }

    do {
        println(list[int])
        int++
    }while (int<list.size)

    if (!list.isEmpty()) {
        println(list)
    }
}