package com.jetgame.tetris.logic

import androidx.compose.ui.geometry.Offset


data class Brick(val location: Offset = Offset(0, 0)) {
    companion object {
        fun of(spirit: Spirit) = spirit.location.map { Brick(it) }

        fun of(xRange: IntRange, yRange: IntRange): List<Brick> =
            mutableListOf<Brick>().apply {
                xRange.forEach { x ->
                    yRange.forEach { y ->
                        this += Brick(Offset(x, y))
                    }
                }
            }

    }

    fun offsetBy(step: Pair<Int, Int>) =
        copy(location = Offset(location.x + step.first, location.y + step.second))

}