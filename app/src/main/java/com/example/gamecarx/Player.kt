package com.example.gamecarx

class Player(cards: MutableList<Card>, mode: Int=0) {

    var drawing_cards: MutableList<Card>
    var playing_cards: MutableList<Card>
    var board_cards: MutableList<Card>
    var discard_cards: MutableList<Card>
    var mindbug: Int = 0
    var mindfrog: Int = 0
    var life_point: Int
    var cursor: Int
    var cursor_choices: MutableList<Card>

    init {
        drawing_cards = ArrayList(cards.subList(0, cards.size / 2))
        playing_cards = ArrayList(cards.subList(cards.size / 2, cards.size))
        board_cards = mutableListOf()
        discard_cards = mutableListOf()
        if(mode == 0) { // Solo
            mindbug = 2
            mindfrog = 0
        }
        else if(mode == 1) { // Multi
            mindbug = 1
            mindfrog = 1
        }
        life_point = 3
        cursor = 0
        cursor_choices = mutableListOf()
    }

    fun drawCard() {
        // Case there was drawing cards
        if (drawing_cards.isNotEmpty()) {
            // add first drowing card to play cards
            playing_cards.add(drawing_cards[0])
            // remove first drawing card
            drawing_cards.removeAt(0)
        }

    }

    fun discardPlayingCard(num: Int) {
        // Case there was drawing cards
        if (playing_cards.isNotEmpty()) {
            discard_cards.add(playing_cards[num])
            // remove first drawing card
            playing_cards.removeAt(num)
        }
    }
    // isLost()
    fun isLost(): Boolean {
        if(drawing_cards.isEmpty() && playing_cards.isEmpty() || life_point <= 0) {
            return true
        }
        else {
            return false
        }
    }
    //  check cards on hand and on board
    //  check life point
    fun playCard(num: Int) {
        // Case there was playing cards
        if (playing_cards.isNotEmpty()) {
            board_cards.add(playing_cards[num])
            // remove first drawing card
            playing_cards.removeAt(num)
        }
        // FUTURE activate "play effect"
    }
    // TODO attackBoard()
    fun attackBoard(num: Int) {
        // TODO choose a card in board to attack with
        //board_cards[num]
        // TODO if there was no enemy card in board remove 1 life point to enemy
        // TODO else enemy choose a card to defend with
        // TODO compare which card is discard or not (special case with two Tough and same power)


        // FUTURE "venomous" keyword
        // FUTURE you can choose enemy card with "hunter" keyword
    }

    fun updateCursorChoice() {
        cursor_choices = (playing_cards + board_cards).toMutableList()
    }


}