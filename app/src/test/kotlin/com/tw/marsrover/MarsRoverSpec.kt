package com.tw.marsrover

import com.tw.marsrover.Command.*
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverSpec : ShouldSpec({
    val plateau = Plateau(5, 5)
    should("return the initial position if the mars rover does not move") {
        MarsRover(plateau).position(Position(0, 0, Direction.N)) shouldBe Position(0, 0, Direction.N)
    }

    should("return the right-hand side of mars rover's orientation when it receive R") {
        MarsRover(plateau).execute(Position(0, 0, Direction.N), R) shouldBe Position(0, 0, Direction.E)
        MarsRover(plateau).execute(Position(0, 0, Direction.E), R) shouldBe Position(0, 0, Direction.S)
        MarsRover(plateau).execute(Position(0, 0, Direction.S), R) shouldBe Position(0, 0, Direction.W)
        MarsRover(plateau).execute(Position(0, 0, Direction.W), R) shouldBe Position(0, 0, Direction.N)
    }

    should("return the left-hand side of mars rover's orientation when it receive L") {
        MarsRover(plateau).execute(Position(0, 0, Direction.N), L) shouldBe Position(0, 0, Direction.W)
        MarsRover(plateau).execute(Position(0, 0, Direction.E), L) shouldBe Position(0, 0, Direction.N)
        MarsRover(plateau).execute(Position(0, 0, Direction.S), L) shouldBe Position(0, 0, Direction.E)
        MarsRover(plateau).execute(Position(0, 0, Direction.W), L) shouldBe Position(0, 0, Direction.S)
    }

    should("return position 1 step further on Y co-ordinates when it receive M given mars rover's orientation is North") {
        MarsRover(plateau).execute(Position(0, 0, Direction.N), M) shouldBe Position(0, 1, Direction.N)
    }

    should("return position 1 step closer on Y co-ordinates when it receive M given mars rover's orientation is South") {
        MarsRover(plateau).execute(Position(0, 1, Direction.S), M) shouldBe Position(0, 0, Direction.S)
    }

    should("return position 1 step further on X co-ordinates when it receive M given mars rover's orientation is East") {
        MarsRover(plateau).execute(Position(0, 0, Direction.E), M) shouldBe Position(1, 0, Direction.E)
    }

    should("return position 1 step closer on X co-ordinates when it receive M given mars rover's orientation is West") {
        MarsRover(plateau).execute(Position(1, 0, Direction.W), M) shouldBe Position(0, 0, Direction.W)
    }

    should("return last position when it receive a serial of command LMLMLMLMM given mars rover's position is (1 2 N)") {
        val commands = arrayOf(L, M, L, M, L, M, L, M, M)
        MarsRover(plateau).execute(Position(1, 2, Direction.N), *commands) shouldBe Position(1, 3, Direction.N)
    }

    should("return last position when it receive a serial of command MMRMMRMRRM given mars rover's position is (3 3 E)") {
        val commands = arrayOf(M, M, R, M, M, R, M, R, R, M)
        MarsRover(plateau).execute(Position(3, 3, Direction.E), *commands) shouldBe Position(5, 1, Direction.E)
    }

    should("return the (1 3 N), (5 1 E) for the exercise") {
        val position1 = Position(1, 2, Direction.N)
        val commands1 = listOf(L, M, L, M, L, M, L, M, M)

        val position2 = Position(3, 3, Direction.E)
        val commands2 = listOf(M, M, R, M, M, R, M, R, R, M)

        val expectedPositions = listOf(Position(1, 3, Direction.N), Position(5, 1, Direction.E))

        plateau.executeCommand(
            listOf(
                Pair(position1, commands1),
                Pair(position2, commands2)
            )
        ) shouldBe expectedPositions
    }
})
