package com.tw.marsrover

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class MarsRoverSpec : ShouldSpec({
    should("return the initial position if the mars rover does not move") {
        MarsRover(0, 0, "N").position() shouldBe Position(0, 0, "N")
    }

    should("return the change the orientation to E when mars rover receive R given the position is (0, 0, N)") {
        MarsRover(0, 0, "N").execute("R") shouldBe Position(0, 0, "E")
    }
})
