package com.tw.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverSpec : ShouldSpec({

    should("return the initial position if the mars rover does not move") {
        MarsRover().position(Position(0, 0, Direction.N)) shouldBe Position(0, 0, Direction.N)
    }

    should("return the right-hand side of mars rover's orientation when it receive R") {
        MarsRover().execute(Position(0, 0, Direction.N), Command.R) shouldBe Position(0, 0, Direction.E)
        MarsRover().execute(Position(0, 0, Direction.E), Command.R) shouldBe Position(0, 0, Direction.S)
        MarsRover().execute(Position(0, 0, Direction.S), Command.R) shouldBe Position(0, 0, Direction.W)
        MarsRover().execute(Position(0, 0, Direction.W), Command.R) shouldBe Position(0, 0, Direction.N)
    }

    should("return the left-hand side of mars rover's orientation when it receive L") {
        MarsRover().execute(Position(0, 0, Direction.N), Command.L) shouldBe Position(0, 0, Direction.W)
        MarsRover().execute(Position(0, 0, Direction.E), Command.L) shouldBe Position(0, 0, Direction.N)
        MarsRover().execute(Position(0, 0, Direction.S), Command.L) shouldBe Position(0, 0, Direction.E)
        MarsRover().execute(Position(0, 0, Direction.W), Command.L) shouldBe Position(0, 0, Direction.S)
    }

    should("return position 1 step further on Y co-ordinates when it receive M given mars rover's orientation is North") {
        MarsRover().execute(Position(0, 0, Direction.N), Command.M) shouldBe Position(0, 1, Direction.N)
    }

    should("return position 1 step closer on Y co-ordinates when it receive M given mars rover's orientation is South") {
        MarsRover().execute(Position(0, 1, Direction.S), Command.M) shouldBe Position(0, 0, Direction.S)
    }

    should("return position 1 step further on X co-ordinates when it receive M given mars rover's orientation is East") {
        MarsRover().execute(Position(0, 0, Direction.E), Command.M) shouldBe Position(1, 0, Direction.E)
    }

    should("return position 1 step closer on X co-ordinates when it receive M given mars rover's orientation is West") {
        MarsRover().execute(Position(1, 0, Direction.W), Command.M) shouldBe Position(0, 0, Direction.W)
    }
})
