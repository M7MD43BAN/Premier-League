package com.shaban.premierleague.util

import com.shaban.premierleague.data.domain.Match

class CsvParser {

    fun parse(line: String): Match {
        val tokens = line.split(",")

        return Match(
            matchDate = tokens[Constant.ColumnIndex.MATCH_DATE],
            homeTeam = tokens[Constant.ColumnIndex.HOME_TEAM],
            awayTeam = tokens[Constant.ColumnIndex.AWAY_TEAM],
            fullTimeHomeGoals = tokens[Constant.ColumnIndex.FULL_TIME_HOME_GOALS],
            fullTimeAwayGoals = tokens[Constant.ColumnIndex.FULL_TIME_AWAY_GOALS],
            halfTimeHomeGoals = tokens[Constant.ColumnIndex.HALF_TIME_HOME_GOALS],
            halfTimeAwayGoals = tokens[Constant.ColumnIndex.HALF_TIME_AWAY_GOALS],
            referee = tokens[Constant.ColumnIndex.REFEREE],
            homeShots = tokens[Constant.ColumnIndex.HOME_SHOTS],
            awayShots = tokens[Constant.ColumnIndex.AWAY_SHOTS],
            homeShotsOnTarget = tokens[Constant.ColumnIndex.HOME_SHOTS_ON_TARGET],
            awayShotsOnTarget = tokens[Constant.ColumnIndex.AWAY_SHOTS_ON_TARGET],
            homeFouls = tokens[Constant.ColumnIndex.HOME_FOULS],
            awayFouls = tokens[Constant.ColumnIndex.AWAY_FOULS],
            homeCorners = tokens[Constant.ColumnIndex.HOME_CORNERS],
            awayCorners = tokens[Constant.ColumnIndex.AWAY_CORNERS],
            homeYellowCards = tokens[Constant.ColumnIndex.HOME_YELLOW_CARDS],
            awayYellowCards = tokens[Constant.ColumnIndex.AWAY_YELLOW_CARDS],
            homeRedCards = tokens[Constant.ColumnIndex.HOME_RED_CARDS],
            awayRedCards = tokens[Constant.ColumnIndex.AWAY_RED_CARDS]
        )
    }
}