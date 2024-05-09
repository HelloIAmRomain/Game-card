package com.example.gamecarx

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class GameTest {
    private lateinit var game_: Game
    @Before
    fun setUp() {
        //cards = Cards("C:\\Users\\johdu\\AndroidStudioProjects\\GameCarx\\app\\src\\main\\res\\dataset\\cards_base.csv")
        game_ = Game()
    }
    @Test
    fun mode_0() {
        game_.mode_0()
        assertEquals(0,0)
    }
}