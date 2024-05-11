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
    fun getCardsPath() {
        assertEquals(/* expected = */ "src/main/assets/dataset/cards_base.csv", /* actual = */ cards_base.cardsPath)
    }

    @Test
    fun setCardsPath() {
        cards_base.cardsPath = "test"
        assertEquals(/* expected = */ "test", /* actual = */ cards_base.cardsPath)
    }

    @Test
    fun getCards() {
        val mycards_base: List<Card>? = cards_base.getCards()
        assertEquals(/* expected = */ 48, /* actual = */ mycards_base?.size)
    }
    @Test
    fun swapCards() {
        var mycards_base = cards_base.getCards()
        var i = 2
        var j = 4
        var t_i = mycards_base!![i]
        var t_j = mycards_base[j]
        mycards_base = cards_base.swapCards(mycards_base, i, j)
        assertEquals(/* expected = */ mycards_base[j], /* actual = */ t_i)
        assertEquals(/* expected = */ mycards_base[i], /* actual = */ t_j)
    }
    @Test
    fun shuffleCards() {
        val mycards_base: MutableList<Card> = cards_base.getCards() as MutableList<Card>
        var t = cards_base.shuffleCards(mycards_base)
        assertEquals(/* expected = */ true, /* actual = */ t.containsAll(mycards_base))
        assertEquals(/* expected = */ true, /* actual = */ mycards_base.containsAll(t))
    }
}