package com.tw.marsrover

class Plateau(val width: Int, val length: Int) {

    fun executeCommand(commands: List<Pair<Position, List<Command>>>): List<Position> =
        commands.map {
            MarsRover(this).execute(it.first, *it.second.toTypedArray())
        }

}