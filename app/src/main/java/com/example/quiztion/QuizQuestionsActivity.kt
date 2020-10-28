package com.example.quiztion

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constents.getQuestions()

        setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)


    }

    @SuppressLint("SetTextI18n")
    private fun setQuestions(){

        val questions = mQuestionsList!![mCurrentPosition - 1]


        optionsView()

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" +"/"+ progressBar.max

        tv_question.text = questions.question
        iv_image.setImageResource(questions.image)
        tv_option_one.text = questions.optionOne
        tv_option_two.text = questions.optionTwo
        tv_option_three.text = questions.optionThree
        tv_option_four.text = questions.optionFour

    }

    private fun optionsView(){

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }


    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
        }



    }

    private fun selectedOptionView(tv: TextView,
    selectedOptionNum: Int){

        optionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selection_option_border_bg)
    }


}