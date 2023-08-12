package com.shaban.premierleague.data

import com.shaban.premierleague.data.domain.Match

object DataManager {
    private val matches = mutableListOf<Match>()
    private var matchIndex = 0

    fun addMatch(match: Match) = matches.add(match)

    fun getCurrentMatch(): Match = matches[matchIndex]

    fun getNextMatch(): Match {
        matchIndex++
        if (matchIndex == matches.size) {
            matchIndex = 0
        }
        return matches[matchIndex]
    }

    fun getPreviousMatch(): Match {
        matchIndex--
        if (matchIndex == -1) {
            matchIndex = matches.size - 1
        }
        return matches[matchIndex]
    }
}