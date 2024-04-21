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
        try {
            val br = BufferedReader(FileReader(cardsPath))
            var line: String?

            // Read the file line by line
            while (br.readLine().also { line = it } != null) {
                // Split the line into fields
                val fields = line!!.split(",")

                // Process the fields as needed

                cards.add(Card(fields[0], fields[1], fields[2], fields[3], fields[4]))
            }
            br.close()
            return cards
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}