package com.example.simplemath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var questionTextView : TextView
    lateinit var answerView : EditText

    var firstNumber : Int = 0
    var secondNumber : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        answerView = findViewById(R.id.answerEditText)

        val button = findViewById<Button>(R.id.answerButton)

        button.setOnClickListener {
            startAnswerActivity()
        }


        setNewQuestion()

    }

    override fun onRestart() {
        super.onRestart()

        answerView.setText("")
        setNewQuestion()

    }

    fun startAnswerActivity() {
        // kolla om rätt eller fel svar
        val answeredCorrect = checkAnswer()
        Log.d("!!!", "Rätt? $answeredCorrect")

        // Starta ny aktivitet och skicka med info
        val intent = Intent(this, AnswerActivity::class.java)
        intent.putExtra("answeredCorrect", answeredCorrect)

        startActivity(intent)

    }

    fun checkAnswer() : Boolean {
        // kolla vad användaren svarat
        val answerText = answerView.text.toString()
        val answerInt = answerText.toIntOrNull()

        // räkna ut rätt svar
        val rightAnswer = firstNumber + secondNumber

        // jämför användarens svar med rätt svar
        // returnera true or false
        return answerInt == rightAnswer


    }

    fun setNewQuestion() {
        firstNumber = (1..20).random()
        secondNumber = (1..20).random()

        questionTextView.text = "$firstNumber + $secondNumber"

    }
}