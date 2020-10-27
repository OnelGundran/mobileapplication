package com.example.quiztion

object Constents{
    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val Q1 = Questions(1,
                " What is the foundation day of University of Cordilleras?",
                R.drawable.uc,
        optionOne = "June19",
        optionTwo = "64th",
        optionThree = "Nov3",
        optionFour = "Today",
        correctAnswer = 1

        )

       questionsList.add(Q1)

        val Q2 = Questions(2,
                " What is the foundation day of University of Cordilleras?",
                R.drawable.uc,
                optionOne = "June19",
                optionTwo = "64th",
                optionThree = "Nov3",
                optionFour = "Today",
                correctAnswer = 1

        )

        questionsList.add(Q2)

        return questionsList
    }


}