package com.example.basketball

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.basketball.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding
    private var localScore = 0
    private var visitorScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score)
        
        // Obtener marcadores
        if (savedInstanceState != null) {
            localScore = savedInstanceState.getInt("localScore", 0)
            visitorScore = savedInstanceState.getInt("visitorScore", 0)
        } else {
            localScore = intent.getIntExtra(Constants.EXTRA_LOCAL_SCORE, 0)
            visitorScore = intent.getIntExtra(Constants.EXTRA_VISITOR_SCORE, 0)
        }
        
        mostrarResultado()

        // Volver explícitamente a la pantalla de inicio (MainActivity)
        binding.buttonBack.setOnClickListener { 
            val intent = Intent(this, MainActivity::class.java).apply {
                // Opcional: limpiar el back stack para que realmente sea "inicio"
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
            finish()
        }
    }

    private fun mostrarResultado() {
        binding.textViewFinalScore.text = "$localScore - $visitorScore"
        
        val mensaje = when {
            localScore > visitorScore -> getString(R.string.result_local_wins)
            visitorScore > localScore -> getString(R.string.result_visitor_wins)
            else -> getString(R.string.result_tie) + " 😔"
        }
        
        binding.textViewResultMessage.text = mensaje
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("localScore", localScore)
        outState.putInt("visitorScore", visitorScore)
    }
}
