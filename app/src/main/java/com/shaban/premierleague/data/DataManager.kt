package com.shaban.premierleague.data

import com.shaban.premierleague.data.domain.Match

object DataManager {
    private val matches = mutableListOf<Match>()
    private var matchIndex = 1

    fun addMatch(match: Match) = matches.add(match)

    fun getCurrentMatch(): Match = matches[matchIndex]

    fun getAllMatches(): List<Match> = matches

    fun getNextMatch(matches: List<Match>): Match {
        matchIndex++
        if (matchIndex >= matches.size) {
            matchIndex = 1
        }
        return matches[matchIndex]
    }

    fun getPreviousMatch(matches: List<Match>): Match {
        matchIndex--
        if (matchIndex <= 0) {
            matchIndex = matches.size - 1
        }
        return matches[matchIndex]
    }

    fun getMatchesByHomeTeam(searchQuery: String): List<Match> {
        return matches.filter { it.homeTeam?.contains(searchQuery, true) == true }
    }
}