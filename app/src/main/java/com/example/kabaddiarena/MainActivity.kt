package com.example.kabaddiarena

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var playerNameInput: EditText
    private lateinit var scoreText: TextView

    private lateinit var raidSuccessBtn: Button
    private lateinit var emptyRaidBtn: Button
    private lateinit var tackleSuccessBtn: Button
    private lateinit var undoBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var resultBtn: Button

    private var score = 0

    private var totalRaids = 0
    private var successfulRaids = 0

    private var totalTackles = 0
    private var successfulTackles = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        playerNameInput = findViewById(R.id.playerNameInput)
        scoreText = findViewById(R.id.scoreText)

        raidSuccessBtn = findViewById(R.id.raidSuccessBtn)
        emptyRaidBtn = findViewById(R.id.emptyRaidBtn)
        tackleSuccessBtn = findViewById(R.id.tackleSuccessBtn)
        undoBtn = findViewById(R.id.undoBtn)
        resetBtn = findViewById(R.id.resetBtn)
        resultBtn = findViewById(R.id.resultBtn)

        updateScore()

        raidSuccessBtn.setOnClickListener {
            score += 2
            totalRaids++
            successfulRaids++
            updateScore()
        }

        emptyRaidBtn.setOnClickListener {
            totalRaids++
            updateScore()
        }

        tackleSuccessBtn.setOnClickListener {
            score += 1
            totalTackles++
            successfulTackles++
            updateScore()
        }

        undoBtn.setOnClickListener {
            if (score > 0) {
                score--
                updateScore()
            }
        }

        resetBtn.setOnClickListener {
            score = 0

            totalRaids = 0
            successfulRaids = 0

            totalTackles = 0
            successfulTackles = 0

            updateScore()
        }

        resultBtn.setOnClickListener {

            val playerName = playerNameInput.text.toString()

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("PLAYER_NAME", playerName)
            intent.putExtra("SCORE", score)

            val raidRate =
                if (totalRaids > 0)
                    (successfulRaids * 100) / totalRaids
                else 0

            val tackleRate =
                if (totalTackles > 0)
                    (successfulTackles * 100) / totalTackles
                else 0

            intent.putExtra("RAID_RATE", raidRate)
            intent.putExtra("TACKLE_RATE", tackleRate)

            startActivity(intent)
        }
    }

    private fun updateScore() {
        scoreText.text = "Score: $score"
    }
}