package com.example.gamecarx

class Game// nb_player can be 2 or 4
// mode can be 0 as normal, 1 first extension, ...
    (var nb_player: Int = 2, var mode: Int = 0) {
    var playerTurn: Int
    var players: MutableList<Player>
    var cardsTurn: MutableList<Card>
    lateinit var cards_base: Cards

    init {
        this.playerTurn = 0
        this.players = mutableListOf()
        this.cardsTurn = mutableListOf()
    }

    fun distribToPlayers(cards_base:Cards) {
        for (i in 1..nb_player) {
            players.add(Player(cards_base.giveCards()))
        }
    }
    fun setPlayerStart(cards_base:Cards) {
        // give cards to each players
        //  cardsTurn.add to display cards that we saw at the beginning
        //  first card to p1
        var p1 = cards_base.giveCard()
        cardsTurn.add(p1)
        //  second card to p2
        var p2 = cards_base.giveCard()
        cardsTurn.add(p2)
        while(true) {
            // Compare them
            if(p1.power < p2.power) {
                playerTurn = 1
                break
            }
            else if (p1.power > p2.power) {
                playerTurn = 0
                break
            }
            // Case it equals, we try again
            p1 = cards_base.giveCard()
            cardsTurn.add(p1)
            p2 = cards_base.giveCard()
            cardsTurn.add(p2)
        }
    }

    fun fight(attackCardNum:Int, defendCardNum:Int, curPlayer: Player, nextPlayer: Player) {
        var attackCardPower:Int = curPlayer.getCardBoard(attackCardNum).power.toInt()


        var defendCardPower:Int = nextPlayer.getCardBoard(defendCardNum).power.toInt()
        if(attackCardPower == defendCardPower) { // FUTURE VENOMOUS
            // discard both card
            curPlayer.discardBoardCard(attackCardNum)
            nextPlayer.discardBoardCard(attackCardNum)
        }
        else if(attackCardPower > defendCardPower) { // FUTUR VENOMOUS
            // discard defend card
            nextPlayer.discardBoardCard(attackCardNum)
        }
        else { // FUTUR VENOMOUS
            // discard  attack card
            curPlayer.discardBoardCard(attackCardNum)
        }
    }

    fun turn() {
        // check if player lost
        var curPlayer = players[playerTurn%2]
        var nextPlayer = players[playerTurn+1%2]
        var attackCardNum: Int
        var defendCardNum: Int
        if(curPlayer.isLost()) {
            // FUTUR (playerTurn+1)%2 win
        }
        // else curPlayer have to choose a card on hand or board
        curPlayer.updateCursorChoice()
        //  choose a card (an integer between 0 and playing_cards + boarding_cards size)
        // var cursor:Int = waitForTouch() || RL_do_something()
        var cursor_curPlayer:Int = (0..curPlayer.cursor_choices.size).random()
        if(cursor_curPlayer >= curPlayer.playing_cards.size) {
            // player attack phase with a card on board
            attackCardNum = cursor_curPlayer - curPlayer.playing_cards.size

            // enemy defend phase with a card
            if(nextPlayer.board_cards.size > 0) {
                var cursor_nextPlayer:Int = (0..nextPlayer.board_cards.size).random()
                defendCardNum = cursor_nextPlayer
                // TODO compare attacker and defender
                fight(attackCardNum, defendCardNum, curPlayer, nextPlayer)
            }
            else {
                nextPlayer.life_point -= 1
            }

        }
        else {
            // play a card on board
            curPlayer.playCard(cursor_curPlayer)
            // FUTUR mindbug phase
        }

        // if(cursor >= curPlayer.playing_cards.size) {
        // // case currPlayer play a card
        //  currPlayer.playCard(cursor - playing_cards.size)
        //  var enemy_cursor:Boolean = waitForEnemyTouch()  || RL_enemy_do_something()
        //  if(enemy_cursor) {
        //  // case enemy use mindbug
        //
        //  }
        // }
        // else {
        // // case currPlayer attack with a card
        //  currplayer.attackBoard(cursor)
        // }
        // Next turn
        playerTurn += 1
    }

    // TODO 1) mode_0
    fun init_mode_0() {
        // Get cards with correct path
        cards_base = Cards("src/main/assets/dataset/cards_base.csv")
        cards_base.shuffleCards()
        // 48 cards
        // distrib cards to players
        distribToPlayers(cards_base)
        // setPlayerStart
        setPlayerStart(cards_base)


        // TODO display  10 drawing cards with number on it for each player
        // TODO display life points
        // TODO draw the cards 5 for players and hide enemy cards
        // TODO turn
        // TODO rule: put a card or attack if you can't you loose
        // TODO rule: at the beginning of a turn if you have less than 1 life point you loose
        // TODO rule: at the beginning of a turn you have to defend or you loose 1 or more life point

        // Case two players
        // Case four players
    }

}