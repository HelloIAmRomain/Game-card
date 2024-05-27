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
    fun init_mode_0() {
        game_.init_mode_0()
        assertEquals(0,0)
    }
    @Test
    fun distribToPlayers_2_players() {
        game_.init_mode_0()
        // Player 1 has got 5 cards in draw
        assertEquals(5,game_.players[0].drawing_cards.size)
        // Player 1 has got 5 cards in hand
        assertEquals(5,game_.players[0].playing_cards.size)
        // Player 1 has got 2 mindbugs
        assertEquals(2,game_.players[0].mindbug)
        // Player 1 has got 0 mindfrog
        assertEquals(0,game_.players[0].mindfrog)

        // Player 2 has got 5 in draw
        assertEquals(5,game_.players[1].drawing_cards.size)
        // Player 2 has got 5 cards in hand
        assertEquals(5,game_.players[1].playing_cards.size)
        // Player 2 has got 2 mindbugs
        assertEquals(2,game_.players[1].mindbug)
        // Player 2 has got 0 mindfrog
        assertEquals(0,game_.players[1].mindfrog)
        // OPTION check if there was no mistake and all cards are here
        // OPTION do the same test with 4 players
    }

    @Test
    fun setPlayerStart_2_players_0() {
        game_.init_mode_0()
        // compare total cards to basic cards number
        var cardsTurnSize = game_.cardsTurn.size
        assertEquals(
            /* expected = */ 48,
            /* actual = */ game_.cardsTurn.size + game_.players[0].playing_cards.size +
                    game_.players[0].drawing_cards.size + game_.players[1].playing_cards.size +
                    game_.players[1].drawing_cards.size + game_.cards_base.getCards().size
        )
        // check if the player turn is good with the two last cards
        if(game_.cardsTurn[cardsTurnSize - 2].power > game_.cardsTurn[cardsTurnSize - 2].power) {
            assertEquals(0, game_.playerTurn)
        }
        if(game_.cardsTurn[cardsTurnSize - 2].power < game_.cardsTurn[cardsTurnSize - 2].power) {
            assertEquals(1, game_.playerTurn)
        }
    }
}