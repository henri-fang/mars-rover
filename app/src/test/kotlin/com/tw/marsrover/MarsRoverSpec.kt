package com.tw.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverSpec : ShouldSpec({
    should("return the initial position if the mars rover does not move") {
        MarsRover(0, 0, "N").position() shouldBe Position(0, 0, "N")
    }

    should("return the right-hand side of mars rover's orientation when it receive R") {
        MarsRover(0, 0, "N").execute("R") shouldBe Position(0, 0, "E")
        MarsRover(0, 0, "E").execute("R") shouldBe Position(0, 0, "S")
        MarsRover(0, 0, "S").execute("R") shouldBe Position(0, 0, "W")
        MarsRover(0, 0, "W").execute("R") shouldBe Position(0, 0, "N")
    }

    should("return the change the orientation to W when mars rover receive L given the position is (0, 0, N)") {
        MarsRover(0, 0, "N").execute("L") shouldBe Position(0, 0, "W")
    }
})
