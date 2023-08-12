package com.shaban.premierleague.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shaban.premierleague.data.DataManager
import com.shaban.premierleague.data.domain.Match
import com.shaban.premierleague.databinding.ActivityMainBinding
import com.shaban.premierleague.util.Constant
import com.shaban.premierleague.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        parseFile()
        addCallBacks()
    }

    private fun addCallBacks() {
        binding.apply {
            icNext.setOnClickListener {
                bindMatch(DataManager.getNextMatch())
            }
            icPrevious.setOnClickListener {
                bindMatch(DataManager.getPreviousMatch())
            }
        }
    }

    private fun parseFile() {
        val inputStream = assets.open(Constant.FILE_NAME)
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()

        buffer.forEachLine { match ->
            val currentMatch = parser.parse(match)
            DataManager.addMatch(currentMatch)
        }
        bindMatch(DataManager.getCurrentMatch())
    }

    private fun bindMatch(match: Match) {
        val scoreText = "${match.fullTimeHomeGoals} - ${match.fullTimeAwayGoals}"
        binding.apply {
            matchDate.text = match.matchDate.toString()
            matchScore.text = scoreText
            homeTeamName.text = match.homeTeam
            awayTeamName.text = match.awayTeam
            refereeName.text = match.referee
            homeTeamHalfTimeGoals.text = match.halfTimeHomeGoals
            awayTeamHalfTimeGoals.text = match.halfTimeAwayGoals
            homeTeamShoot.text = match.awayShots
            awayTeamShoot.text = match.awayShots
            homeTeamShootOnTarget.text = match.homeShotsOnTarget
            awayTeamShootOnTarget.text = match.awayShotsOnTarget
            homeTeamFoul.text = match.homeFouls
            awayTeamFoul.text = match.awayFouls
            homeTeamYellowCard.text = match.homeYellowCards
            awayTeamYellowCard.text = match.awayYellowCards
            homeTeamRedCard.text = match.homeRedCards
            awayTeamRedCard.text = match.awayRedCards
            homeTeamCornerKick.text = match.homeCorners
            awayTeamCornerKick.text = match.awayCorners
        }
        getTeamLogo(match)
    }

    private fun getTeamLogo(match: Match) {

    }
}