package com.example.gamecarx

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runners.Parameterized

class CardTest {
    private lateinit var cards: Cards
    private lateinit var card1: Card
    private lateinit var card2: Card
    @Before
    fun setUp() {
        cards = Cards("C:\\Users\\johdu\\AndroidStudioProjects\\GameCarx\\app\\src\\main\\res\\dataset\\cards_base.csv")
        card1 = cards.getCards()?.get(1)!! // first card
        card2 = cards.getCards()?.get(2)!! // second card
    }

    @Test
    fun getKeywords() {
        var kwc1: List<String> = listOf("Poisonous")
        assertEquals(/* expected = */ kwc1, /* actual = */ card1.keywords)
        var kwc2: List<String> = "".split(",")
        assertEquals(/* expected = */ kwc2, /* actual = */ card2.keywords)
    }

    @Test
    fun getId_card() {
    }

    @Test
    fun getName() {
    }

    @Test
    fun getPower() {
    }

    @Test
    fun getDescription() {
    }
}