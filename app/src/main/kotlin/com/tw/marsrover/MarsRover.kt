package com.tw.marsrover

class MarsRover(private val x: Int, private val y: Int, private val orientation: Direction) {

    fun position(): Position {
        return Position(x, y, orientation)
    }

    fun execute(command: Command): Position =
        when (command) {
            Command.L -> turnLeft()
            Command.R -> turnRight()
            Command.M -> move()
        }

    private fun move(): Position =
        when (orientation) {
            Direction.N -> Position(x, y + 1, orientation)
            Direction.S -> Position(x, y - 1, orientation)
            Direction.E -> Position(x + 1, y, orientation)
            Direction.W -> Position(x - 1, y, orientation)
        }

    private fun turnRight(): Position = when (orientation) {
        Direction.N -> Position(x, y, Direction.E)
        Direction.E -> Position(x, y, Direction.S)
        Direction.S -> Position(x, y, Direction.W)
        Direction.W -> Position(x, y, Direction.N)
    }

    private fun turnLeft(): Position = when (orientation) {
        Direction.N -> Position(x, y, Direction.W)
        Direction.E -> Position(x, y, Direction.N)
        Direction.S -> Position(x, y, Direction.E)
        Direction.W -> Position(x, y, Direction.S)
    }
}
