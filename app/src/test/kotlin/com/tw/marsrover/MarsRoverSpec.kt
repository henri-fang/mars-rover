package com.tw.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverSpec : ShouldSpec({
    should("return the initial position if the mars rover does not move") {
        MarsRover(0, 0, Direction.N).position() shouldBe Position(0, 0, Direction.N)
    }

    should("return the right-hand side of mars rover's orientation when it receive R") {
        MarsRover(0, 0, Direction.N).execute(Command.R) shouldBe Position(0, 0, Direction.E)
        MarsRover(0, 0, Direction.E).execute(Command.R) shouldBe Position(0, 0, Direction.S)
        MarsRover(0, 0, Direction.S).execute(Command.R) shouldBe Position(0, 0, Direction.W)
        MarsRover(0, 0, Direction.W).execute(Command.R) shouldBe Position(0, 0, Direction.N)
    }

    should("return the left-hand side of mars rover's orientation when it receive L") {
        MarsRover(0, 0, Direction.N).execute(Command.L) shouldBe Position(0, 0, Direction.W)
        MarsRover(0, 0, Direction.E).execute(Command.L) shouldBe Position(0, 0, Direction.N)
        MarsRover(0, 0, Direction.S).execute(Command.L) shouldBe Position(0, 0, Direction.E)
        MarsRover(0, 0, Direction.W).execute(Command.L) shouldBe Position(0, 0, Direction.S)
    }
})
