package com.example.gamecarx

class Player(cards: MutableList<Card>, mode: Int) {

    var drawing_cards: MutableList<Card>
    var playing_cards: MutableList<Card>
    var board_cards: MutableList<Card>
    var mindbug: Int = 0
    var mindfrog: Int = 0
    var life_point: Int

    init {
        drawing_cards = ArrayList(cards.subList(0, cards.size / 2))
        playing_cards = ArrayList(cards.subList(cards.size / 2, cards.size))
        board_cards = mutableListOf()
        if(mode == 0) { // Solo
            mindbug = 2
            mindfrog = 0
        }
        else if(mode == 1) { // Multi
            mindbug = 1
            mindfrog = 1
        }
        life_point = 3
    }

    // TODO drawCard()
    fun drawCard() {
        // Case there was drawing cards
        if (drawing_cards.isNotEmpty()) {
            // add first drowing card to play cards
            playing_cards.add(drawing_cards[0])
            // remove first drawing card
            drawing_cards.removeAt(0)
        }

    }
    // TODO isLost()
    //  check cards on hand and on board
    //  check life point
    // TODO playCard()
    // TODO attackBoard()


}