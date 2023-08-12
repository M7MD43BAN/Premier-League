package com.shaban.premierleague.data.domain

data class Match(
    val matchDate: String? = null,
    val homeTeam: String? = null,
    val awayTeam: String? = null,
    val fullTimeHomeGoals: String? = null,
    val fullTimeAwayGoals: String? = null,
    val halfTimeHomeGoals: String? = null,
    val halfTimeAwayGoals: String? = null,
    val referee: String? = null,
    val homeShots: String? = null,
    val awayShots: String? = null,
    val homeShotsOnTarget: String? = null,
    val awayShotsOnTarget: String? = null,
    val homeFouls: String? = null,
    val awayFouls: String? = null,
    val homeCorners: String? = null,
    val awayCorners: String? = null,
    val homeYellowCards: String? = null,
    val awayYellowCards: String? = null,
    val homeRedCards: String? = null,
    val awayRedCards: String? = null
)
