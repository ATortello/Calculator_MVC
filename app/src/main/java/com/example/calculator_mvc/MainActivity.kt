package com.example.calculator_mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var valueMainExpression: String = ""
    var valueResult: String = ""
    var operator: Int = 0
    var num1: Double = 0.0
    var num2: Double = 0.0
    lateinit var tvMainExpression: TextView
    lateinit var tvMainCurrentResults: TextView
    lateinit var btMainClear: Button
    lateinit var btMainEqual: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMainExpression = findViewById(R.id.tvMainExpression)
        tvMainCurrentResults = findViewById(R.id.tvMainCurrentResults)
        btMainClear = findViewById(R.id.btMainClear)
        btMainEqual = findViewById(R.id.btMainEqual)

        btMainEqual.setOnClickListener {
            num2 = tvMainCurrentResults.text.toString().toDouble()

            when(operator){
                1 -> valueResult = (num1 + num2).toString()
                2 -> valueResult = (num1 - num2).toString()
                3 -> valueResult = (num1 * num2).toString()
                4 -> valueResult = (num1 / num2).toString()
            }

            tvMainCurrentResults.setText(valueResult)
            tvMainExpression.setText("")
        }

        btMainClear.setOnClickListener {
            operator = 0
            num1 = 0.0
            num2 = 0.0
            tvMainExpression.setText("")
            tvMainCurrentResults.setText("")
        }
    }
    fun pressedKey(view: View){
        valueMainExpression = tvMainCurrentResults.text.toString()
//        num2 = tvMainCurrentResults.text.toString()

        when(view.id){
            R.id.btMainZero -> tvMainCurrentResults.setText(valueMainExpression + "0")
            R.id.btMainOne -> tvMainCurrentResults.setText(valueMainExpression + "1")
            R.id.btMainTwo -> tvMainCurrentResults.setText(valueMainExpression + "2")
            R.id.btMainThree -> tvMainCurrentResults.setText(valueMainExpression + "3")
            R.id.btMainFour -> tvMainCurrentResults.setText(valueMainExpression + "4")
            R.id.btMainFive -> tvMainCurrentResults.setText(valueMainExpression + "5")
            R.id.btMainSix -> tvMainCurrentResults.setText(valueMainExpression + "6")
            R.id.btMainSeven -> tvMainCurrentResults.setText(valueMainExpression + "7")
            R.id.btMainEight -> tvMainCurrentResults.setText(valueMainExpression + "8")
            R.id.btMainNine -> tvMainCurrentResults.setText(valueMainExpression + "9")
            R.id.btMainDot -> tvMainCurrentResults.setText(valueMainExpression + ".")
        }
    }
    fun selectOperator(view: View){
        valueMainExpression = tvMainCurrentResults.text.toString()
        num1 = valueMainExpression.toDouble()
        tvMainCurrentResults.setText("")

        when(view.id){
            /*R.id.btMainClear -> tvMainCurrentResults.setText("0")*/
            R.id.btMainPlus -> {
                tvMainExpression.setText(valueMainExpression + "+")
                operator = 1
            }
            R.id.btMainMinus -> {
                tvMainExpression.setText(valueMainExpression + "-")
                operator = 2
            }
            R.id.btMainMultiplication -> {
                tvMainExpression.setText(valueMainExpression + "X")
                operator = 3
            }
            R.id.btMainDivision -> {
                tvMainExpression.setText(valueMainExpression + "/")
                operator = 4
            }
        }
    }
}