package com.example.basketball

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.basketball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var localScore = 0
    private var visitorScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        // Recuperar marcadores si se rotó la pantalla
        if (savedInstanceState != null) {
            localScore = savedInstanceState.getInt("localScore", 0)
            visitorScore = savedInstanceState.getInt("visitorScore", 0)
        }
        
        updateScores()
        configurarBotones()
    }

    private fun configurarBotones() {
        // Equipo Local
        binding.buttonLocalPlus1.setOnClickListener {
            localScore++
            updateScores()
        }
        
        binding.buttonLocalPlus2.setOnClickListener {
            localScore += 2
            updateScores()
        }
        
        binding.buttonLocalMinus.setOnClickListener {
            if (localScore > 0) {
                localScore--
                updateScores()
            }
        }
        
        // Equipo Visitante
        binding.buttonVisitorPlus1.setOnClickListener {
            visitorScore++
            updateScores()
        }
        
        binding.buttonVisitorPlus2.setOnClickListener {
            visitorScore += 2
            updateScores()
        }
        
        binding.buttonVisitorMinus.setOnClickListener {
            if (visitorScore > 0) {
                visitorScore--
                updateScores()
            }
        }
        
        // Botones de control
        binding.buttonReset.setOnClickListener {
            localScore = 0
            visitorScore = 0
            updateScores()
        }
        
        binding.buttonNext.setOnClickListener {
            irAResultados()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("localScore", localScore)
        outState.putInt("visitorScore", visitorScore)
    }

    private fun updateScores() {
        binding.textViewLocalScore.text = localScore.toString()
        binding.textViewVisitorScore.text = visitorScore.toString()
    }

    private fun irAResultados() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(Constants.EXTRA_LOCAL_SCORE, localScore)
        intent.putExtra(Constants.EXTRA_VISITOR_SCORE, visitorScore)
        startActivity(intent)
    }
}
