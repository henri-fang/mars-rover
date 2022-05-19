package com.tw.marsrover

class MarsRover(private val x: Int, private val y: Int, private val orientation: String) {

    fun position(): Position {
        return Position(x, y, orientation)
    }

    fun execute(command: String): Position {
        if (command == "R"){
            return Position(x, y, "E")
        }else{
            return Position(x, y, orientation)
        }
    }

}
