package com.example.gamecarx

import com.example.gamecarx.Card

import java.io.BufferedReader
import java.io.FileReader

class Cards {
    var cardsPath: String
    private var cards: MutableList<Card>
    constructor(cardsPath: String) {
        this.cardsPath = cardsPath
        this.cards = initCards()!!
    }

    fun getCards():MutableList<Card> {
        return cards
    }

    fun initCards(): MutableList<Card>? {
        var nb: Int
        var cards: MutableList<Card> = ArrayList()
        try {
            val br = BufferedReader(FileReader(this.cardsPath))
            var line: String?

            // Read the file line by line except first line
            br.readLine()

            while (br.readLine().also { line = it } != null) {
                // Split the line into fields
                val fields = line!!.split("|")
                // Process the fields as needed
                nb = fields[5].toInt()
                //println(fields[0])
                // Add one or more cards
                while(nb > 0) {
                    cards.add(Card(fields[0], fields[1], fields[2], fields[3], fields[4]))
                    nb--
                }
            }
            br.close()
            return cards
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
    fun swapCards(i: Int, j: Int): MutableList<Card> {
        var jbis = j
        if(i == j) { // Case it is the same card, take the next card
            jbis = j + 1
        }
        var t = this.cards[i]
        this.cards[i] = this.cards[jbis]
        this.cards[jbis] = t
        return this.cards
    }

    fun shuffleCards(i_MIN: Int=200, i_MAX: Int=500) {
        // shuffle the cards given
        var rnd_swaps = (i_MIN..i_MAX).random()
        var i_swap = (0..this.cards.size-2).random()
        var j_swap = (0..this.cards.size-2).random()
        while(rnd_swaps>0) { // for each swap
            --rnd_swaps
            this.cards = swapCards(i_swap, j_swap)
            i_swap = (0..this.cards.size-2).random() // take number between 0 and max numbers cards less 2
            j_swap = (0..this.cards.size-2).random() // take number between 0 and max numbers cards less 2
            //println(i_swap.toString() + " " + j_swap + " " + cards)
        }
    }

    fun giveCards(mode: Int): MutableList<Card> {
        var cards_to_give: MutableList<Card> = ArrayList()
        var it: Int
        if(mode == 0) { // solo
            it = 10
        }
        else { // multi
            it = 6
        }
        var i = 0
        while(i < it) {
            //   add cards on new list
            cards_to_give.add(this.cards[0])
            //   remove previous cards from cards
            this.cards.removeAt(0)
            ++i
        }
        return cards_to_give
    }

}