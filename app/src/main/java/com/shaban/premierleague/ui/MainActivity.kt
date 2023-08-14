package com.shaban.premierleague.ui

import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import com.shaban.premierleague.R
import com.shaban.premierleague.data.DataManager
import com.shaban.premierleague.data.domain.Match
import com.shaban.premierleague.databinding.ActivityMainBinding
import com.shaban.premierleague.util.Constant
import com.shaban.premierleague.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String = this::class.java.simpleName
    override val bindingInflater: (layoutInflater: LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private var currentMatches: List<Match> = emptyList()

    override fun setup() {
        parseFile()
        currentMatches = DataManager.getAllMatches()
    }

    override fun addCallBacks() {
        binding.icNext.setOnClickListener {
            bindMatch(DataManager.getNextMatch(currentMatches))
        }

        binding.icPrevious.setOnClickListener {
            bindMatch(DataManager.getPreviousMatch(currentMatches))
        }

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchQuery = newText.orEmpty()
                currentMatches = if (searchQuery.isNotEmpty()) {
                    DataManager.getMatchesByHomeTeam(searchQuery)
                } else {
                    DataManager.getAllMatches()
                }
                updateMatchList(currentMatches)
                return true
            }
        })
    }

    private fun updateMatchList(matches: List<Match>) {
        if (matches.isNotEmpty()) {
            bindMatch(matches[1])
            contentVisibility(View.VISIBLE)
            binding.searchPlaceholder.visibility = View.GONE
        } else {
            contentVisibility(View.GONE)
            binding.searchPlaceholder.visibility = View.VISIBLE
        }
    }

    private fun contentVisibility(visibility: Int) {
        binding.apply {
            matchDetailsTv.visibility = visibility
            cardItem.visibility = visibility
            nextPreviousCard.visibility = visibility
            matchStatisticTv.visibility = visibility
            matchStatisticLayout.visibility = visibility
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
        val homeLogoResourceId = getTeamLogoResource(match.homeTeam)
        val awayLogoResourceId = getTeamLogoResource(match.awayTeam)

        if (homeLogoResourceId != 0 && awayLogoResourceId != 0) {
            binding.homeTeamLogo.setImageResource(homeLogoResourceId)
            binding.awayTeamLogo.setImageResource(awayLogoResourceId)
        }
    }

    private fun getTeamLogoResource(teamName: String?): Int {
        val teamLogoMap = mapOf(
            "Arsenal" to R.drawable.arsenal,
            "Bournemouth" to R.drawable.bournemouth_fc,
            "Brighton" to R.drawable.brighton,
            "Burnley" to R.drawable.burnley,
            "Cardiff" to R.drawable.cardiff,
            "Chelsea" to R.drawable.chelsea,
            "Crystal Palace" to R.drawable.crystalpalace,
            "Everton" to R.drawable.everton,
            "Fulham" to R.drawable.fulham,
            "Huddersfield" to R.drawable.huddersfield,
            "Leicester" to R.drawable.leicester,
            "Liverpool" to R.drawable.liverpool,
            "Man City" to R.drawable.mancity,
            "Man United" to R.drawable.manchester_united_fc,
            "Newcastle" to R.drawable.newcastle,
            "Southampton" to R.drawable.southampton,
            "Tottenham" to R.drawable.tottenham,
            "Watford" to R.drawable.watford,
            "West Ham" to R.drawable.westham_united,
            "Wolves" to R.drawable.wolves
        )

        return teamLogoMap[teamName] ?: 0
    }
}