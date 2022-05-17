package com.tw.marsrover

import io.kotest.core.spec.style.ShouldSpec

class MarsRoverSpec : ShouldSpec({
    should("return the initial position if the mars rover does not move") {
        MarsRover(0, 0, "N").position() shouldBe Position(0,0, "N")
    }

})
