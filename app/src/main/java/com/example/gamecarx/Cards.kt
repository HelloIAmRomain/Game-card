package com.example.gamecarx

import com.example.gamecarx.Card

import java.io.BufferedReader
import java.io.FileReader

class Cards {
    var cardsPath: String

    constructor(cardsPath: String) {
        this.cardsPath = cardsPath
    }

    fun getCards(): MutableList<Card>? {
        val cards = mutableListOf<Card>()
        var nb: Int
        try {
            val br = BufferedReader(FileReader(cardsPath))
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
    fun swapCards(cards: MutableList<Card>?, i: Int, j: Int): MutableList<Card> {
        var jbis = j
        if(i == j) { // Case it is the same card, take the next card
            jbis = j + 1
        }
        var t = cards!![i]
        cards[i] = cards[jbis]
        cards[jbis] = t
        return cards
    }

    fun shuffleCards(cards: MutableList<Card>, i_MIN: Int=200, i_MAX: Int=500): MutableList<Card> {
        // shuffle the cards given
        var rnd_swaps = (i_MIN..i_MAX).random()
        var i_swap = (0..cards.size-2).random()
        var j_swap = (0..cards.size-2).random()
        var cards_ = cards
        while(rnd_swaps>0) { // for each swap
            --rnd_swaps
            cards_ = swapCards(cards_, i_swap, j_swap)
            i_swap = (0..cards.size-2).random() // take number between 0 and max numbers cards less 2
            j_swap = (0..cards.size-2).random() // take number between 0 and max numbers cards less 2
            //println(i_swap.toString() + " " + j_swap + " " + cards)
        }
        return cards
    }

}