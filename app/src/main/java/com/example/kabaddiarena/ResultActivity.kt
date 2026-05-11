package com.example.kabaddiarena

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        val resultText = findViewById<TextView>(R.id.resultText)

        val playerName = intent.getStringExtra("PLAYER_NAME")
        val score = intent.getIntExtra("SCORE", 0)
        val raidRate = intent.getIntExtra("RAID_RATE", 0)
        val tackleRate = intent.getIntExtra("TACKLE_RATE", 0)

        resultText.text =
            "🏆 Player: $playerName\n\n" +
                    "Points: $score\n\n" +
                    "Raid Success: $raidRate%\n\n" +
                    "Tackle Success: $tackleRate%"
    }
}