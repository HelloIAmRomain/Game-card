package com.example.gamecarx

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class CardsTest {
    private lateinit var cards_base: Cards
    @Before
    fun setUp() {
        //cards = Cards("C:\\Users\\johdu\\AndroidStudioProjects\\GameCarx\\app\\src\\main\\res\\dataset\\cards_base.csv")
        cards_base = Cards("src/main/assets/dataset/cards_base.csv")
    }
    @Test
    fun getCardsPath_0() {
        assertEquals(/* expected = */ "src/main/assets/dataset/cards_base.csv", /* actual = */ cards_base.cardsPath)
    }

    @Test
    fun setCardsPath() {
        cards_base.cardsPath = "test"
        assertEquals(/* expected = */ "test", /* actual = */ cards_base.cardsPath)
    }

    @Test
    fun getCards_0() {
        val mycards_base: List<Card>? = cards_base.getCards()
        assertEquals(/* expected = */ 48, /* actual = */ mycards_base?.size)
    }
    @Test
    fun swapCards() {
        var mycards_base = cards_base.getCards()
        var i = 2
        var j = 4
        var t_i = mycards_base[i]
        var t_j = mycards_base[j]
        mycards_base = cards_base.swapCards(i, j)
        assertEquals(/* expected = */ mycards_base[j], /* actual = */ t_i)
        assertEquals(/* expected = */ mycards_base[i], /* actual = */ t_j)
    }
    @Test
    fun shuffleCards() {
        val mycards_base: MutableList<Card> = cards_base.getCards() as MutableList<Card>
        cards_base.shuffleCards()
        assertEquals(/* expected = */ true, /* actual = */ cards_base.getCards().containsAll(mycards_base))
        assertEquals(/* expected = */ true, /* actual = */ mycards_base.containsAll(cards_base.getCards()))
    }
    @Test
    fun giveCards_2_players_0() {
        assertEquals(/* expected = */ 10, /* actual = */ cards_base.giveCards(0).size)
        assertEquals(/* expected = */ 38, /* actual = */ cards_base.getCards().size)
    }
    @Test
    fun giveCards_4_players_0() {
        assertEquals(/* expected = */ 6, /* actual = */ cards_base.giveCards(1).size)
        assertEquals(/* expected = */ 42, /* actual = */ cards_base.getCards().size)
    }
    @Test
    fun giveCard_0() {
        assertEquals(/* expected = */ 48, /* actual = */ cards_base.getCards().size)
        var card_given = cards_base.giveCard()
        assertEquals(/* expected = */ true, /* actual = */ card_given is Card)
        assertEquals(/* expected = */ 47, /* actual = */ cards_base.getCards().size)
    }
}