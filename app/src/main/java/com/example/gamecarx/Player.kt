package com.example.gamecarx

class Player(cards: MutableList<Card>, mode: Int) {

    var drawing_cards: MutableList<Card>
    var playing_cards: MutableList<Card>
    var board_cards: MutableList<Card>
    var mindbug: Int = 0
    var mindfrog: Int = 0
    var life_point: Int

    init {
        this.drawing_cards = cards.subList(0, cards.size / 2)
        this.playing_cards = cards.subList(cards.size / 2, cards.size)
        this.board_cards = mutableListOf()
        if(mode == 0) { // Solo
            this.mindbug = 2
            this.mindfrog = 0
        }
        else if(mode == 1) { // Multi
            this.mindbug = 1
            this.mindfrog = 1
        }
        this.life_point = 3
    }

    // TODO playCard()
    // TODO attackBoard()


}