package com.shaban.premierleague.util

import com.shaban.premierleague.data.domain.Match

class CsvParser {

    fun parse(line: String): Match {
        val tokens = line.split(",")
        return Match(
            tokens[Constant.ColumnIndex.MATCH_DATE],
            tokens[Constant.ColumnIndex.HOME_TEAM],
            tokens[Constant.ColumnIndex.AWAY_TEAM],
            tokens[Constant.ColumnIndex.FULL_TIME_HOME_GOALS],
            tokens[Constant.ColumnIndex.FULL_TIME_AWAY_GOALS],
            tokens[Constant.ColumnIndex.HALF_TIME_HOME_GOALS],
            tokens[Constant.ColumnIndex.HALF_TIME_AWAY_GOALS],
            tokens[Constant.ColumnIndex.REFEREE],
            tokens[Constant.ColumnIndex.HOME_SHOTS],
            tokens[Constant.ColumnIndex.AWAY_SHOTS],
            tokens[Constant.ColumnIndex.HOME_SHOTS_ON_TARGET],
            tokens[Constant.ColumnIndex.AWAY_SHOTS_ON_TARGET],
            tokens[Constant.ColumnIndex.HOME_FOULS],
            tokens[Constant.ColumnIndex.AWAY_FOULS],
            tokens[Constant.ColumnIndex.HOME_CORNERS],
            tokens[Constant.ColumnIndex.AWAY_CORNERS],
            tokens[Constant.ColumnIndex.HOME_YELLOW_CARDS],
            tokens[Constant.ColumnIndex.AWAY_YELLOW_CARDS],
            tokens[Constant.ColumnIndex.HOME_RED_CARDS],
            tokens[Constant.ColumnIndex.AWAY_RED_CARDS]
        )
    }
}