package com.example.gamecarx

import com.example.gamecarx.Card

import java.io.BufferedReader
import java.io.FileReader

class Cards {
    var cardsPath: String

    constructor(cardsPath: String) {
        this.cardsPath = cardsPath
    }

    fun getCards(): List<Card>? {
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
                println(fields[0])
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
    fun shuffleCards(cards: List<Card>): List<Card> {
        // TODO shuffle the cards given
        return cards
    }

}