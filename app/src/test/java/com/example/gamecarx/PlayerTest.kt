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
    fun getBoard_cards_0_init() {
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
    @Test
    fun drawCard() {
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        p1.drawCard()
        assertEquals(4, p1.drawing_cards.size)
        assertEquals(6, p1.playing_cards.size)
        assertEquals(0, p1.board_cards.size)
        // TODO 1) test with first card in draw_card and in playing card
        // TODO 2) same tests mode 2
    }
    @Test
    fun discardPlayingCard() {
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        var cards_size_expected = 4
        while(cards_size_expected != 0) {
            p1.discardPlayingCard(1)
            assertEquals(cards_size_expected, p1.playing_cards.size)
            --cards_size_expected
        }
        // TODO check if we discard the right car from the hand
    }
    @Test
    fun isLostByCard() {
        // check card to play
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        // draw 5 cards
        var nb_card_to_draw = 5
        while(nb_card_to_draw != 0) {
            p1.drawCard()
            --nb_card_to_draw
        }
        // discard 10 cards and test if it lost or not
        var nb_card_to_discard = 10
        while(nb_card_to_discard != 0) {
            // we don't lose when we have cards
            assertEquals(false, p1.isLost())
            p1.discardPlayingCard(0)
            --nb_card_to_discard
        }
        // we lose when we have all in  discard card
        assertEquals(true, p1.isLost())
    }
    @Test
    fun isLostByLife() {
        // check life
        mode = 0
        p1 = Player(cards_base.giveCards(mode),mode)
        p1.life_point = 1
        assertEquals(false, p1.isLost())
        p1.life_point = -1
        assertEquals(true, p1.isLost())
        p1.life_point = 0
        assertEquals(true, p1.isLost())
    }

}