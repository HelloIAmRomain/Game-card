package com.example.gamecarx

class Game {
    var nb_player: Int
    var mode: Int

    constructor(nb_player: Int=2, mode: Int=0) {
        // nb_player can be 2 or 4
        // mode can be 0 as normal, 1 first extension, ...
        this.nb_player = nb_player
        this.mode = mode
    }

    // TODO 1) mode_0
    // TODO 2) tests
}