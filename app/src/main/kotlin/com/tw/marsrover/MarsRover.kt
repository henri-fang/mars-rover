package com.tw.marsrover

class MarsRover {

    fun position(position: Position): Position {
        return position
    }

    fun execute(position: Position, command: Command): Position =
        when (command) {
            Command.L -> turnLeft(position)
            Command.R -> turnRight(position)
            Command.M -> move(position)
        }

    private fun move(position: Position): Position =
        when (position.orientation) {
            Direction.N -> Position(position.x, position.y + 1, position.orientation)
            Direction.S -> Position(position.x, position.y - 1, position.orientation)
            Direction.E -> Position(position.x + 1, position.y, position.orientation)
            Direction.W -> Position(position.x - 1, position.y, position.orientation)
        }

    private fun turnRight(position: Position): Position = when (position.orientation) {
        Direction.N -> Position(position.x, position.y, Direction.E)
        Direction.E -> Position(position.x, position.y, Direction.S)
        Direction.S -> Position(position.x, position.y, Direction.W)
        Direction.W -> Position(position.x, position.y, Direction.N)
    }

    private fun turnLeft(position: Position): Position = when (position.orientation) {
        Direction.N -> Position(position.x, position.y, Direction.W)
        Direction.E -> Position(position.x, position.y, Direction.N)
        Direction.S -> Position(position.x, position.y, Direction.E)
        Direction.W -> Position(position.x, position.y, Direction.S)
    }
}
