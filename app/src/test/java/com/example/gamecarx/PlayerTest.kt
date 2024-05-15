package com.example.gamecarx

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class PlayerTest {
    lateinit var p1: Player
    lateinit var cards_base: Cards
    var mode: Int = 0
    @Before
    fun setUp() {
        cards_base = Cards("src/main/assets/dataset/cards_base.csv")

    }

    @Test
    fun getDrawing_cards_0_init() {
        // give 10 cards to player
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(5, p1.drawing_cards.size)
    }

    @Test
    fun getDrawing_cards_1_init() {
        // give 6 cards to player
        mode = 1
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(3, p1.drawing_cards.size)
    }

    @Test
    fun setDrawing_cards() {
    }

    @Test
    fun getPlaying_cards_0_init() {
        // draw 5 cards
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(5, p1.playing_cards.size)
    }

    @Test
    fun getPlaying_cards_1_init() {
        // draw 3 cards
        mode = 1
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(3, p1.playing_cards.size)
    }

    @Test
    fun setPlaying_cards() {
    }

    @Test
    fun getBoard_cards_init() {
        // board is empty
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(0, p1.board_cards.size)
    }

    @Test
    fun setBoard_cards() {
    }

    @Test
    fun getMindbug_0_init() {
        // 2 mindbug
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(2, p1.mindbug)
    }

    @Test
    fun getMindbug_1_init() {
        // 1 mindbug
        mode = 1
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(1, p1.mindbug)
    }

    @Test
    fun setMindbug() {
    }

    @Test
    fun getMindfrog_0_init() {
        // 0 mindfrog
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(0, p1.mindfrog)

    }

    @Test
    fun getMindfrog_1_init() {
        // 1 mindfrog
        mode = 1
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(1, p1.mindfrog)

    }

    @Test
    fun setMindfrog() {
    }

    @Test
    fun getLife_point_init() {
        // 3 life point
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        assertEquals(3, p1.life_point)

    }

    @Test
    fun setLife_point() {
    }
}