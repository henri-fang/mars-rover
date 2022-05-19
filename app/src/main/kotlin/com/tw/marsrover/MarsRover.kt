package com.tw.marsrover

class MarsRover(private val x: Int, private val y: Int, private val orientation: String) {

    fun position(): Position {
        return Position(x, y, orientation)
    }

    fun execute(command: String): Position = when (command) {
        "R" -> {
            Position(x, y, "E")
        }
        "L" -> {
            Position(x, y, "W")
        }
        else -> {
            Position(x, y, orientation)
        }
    }

}
