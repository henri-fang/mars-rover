package com.tw.marsrover

class MarsRover(private val plateau: Plateau) {

    fun position(position: Position): Position {
        return position
    }

    fun execute(position: Position, vararg commands: Command): Position {
        var pos = position
        commands.toList().forEach {
            pos = execute1(pos, it)
        }
        return pos
    }

    private fun execute1(position: Position, command: Command): Position = when (command) {
        Command.L -> turnLeft(position)
        Command.R -> turnRight(position)
        Command.M -> move(position)
    }

    private fun move(position: Position): Position = when (position.orientation) {
        Direction.N -> Position(position.x, edgeOnCoordinate(position.y + 1, plateau.length), position.orientation)
        Direction.S -> Position(position.x, edgeOnCoordinate(position.y - 1, plateau.length), position.orientation)
        Direction.E -> Position(edgeOnCoordinate(position.x + 1, plateau.width), position.y, position.orientation)
        Direction.W -> Position(edgeOnCoordinate(position.x - 1, plateau.width), position.y, position.orientation)
    }

    private fun edgeOnCoordinate(value: Int, limit: Int): Int = when {
        value < 0 -> 0
        value > limit -> limit
        else -> value
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
