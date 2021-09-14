package com.example.simplemath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var answerTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        answerTextView = findViewById(R.id.textView)

        val answer = intent.getBooleanExtra("answeredCorrect", false)
        Log.d("!!!AnswerActivity", "Rätt? $answer")

        if (answer) {
            answerTextView.text = "Rätt svar!"
        } else {
            answerTextView.text = "Fel svar!"
        }

    }


}