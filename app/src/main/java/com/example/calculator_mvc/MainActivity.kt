package com.example.calculator_mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var valueMainExpression: String = ""
    var valueResult: String = ""
    var operation: String = ""
    var operator: Int = 0
    var dotFlag: Int = 0
    var num1: Double = 0.0
    var num2: Double = 0.0

    /*TextViews to show information*/
    lateinit var tvMainExpression: TextView
    lateinit var tvMainCurrentResults: TextView

    /*Operation Buttons*/
    lateinit var btMainClear: Button
    /*lateinit var btMainParenthesis: Button
    lateinit var btMainPercentage: Button*/
    lateinit var btMainDivision: Button
    lateinit var btMainMultiplication: Button
    lateinit var btMainMinus: Button
    lateinit var btMainPlus: Button
    lateinit var btMainEqual: Button
    lateinit var btMainRet: Button

    /*All Number Buttons*/
    lateinit var btMainDot: Button
    lateinit var btMainZero: Button
    lateinit var btMainOne: Button
    lateinit var btMainTwo: Button
    lateinit var btMainThree: Button
    lateinit var btMainFour: Button
    lateinit var btMainFive: Button
    lateinit var btMainSix: Button
    lateinit var btMainSeven: Button
    lateinit var btMainEight: Button
    lateinit var btMainNine: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Binding visual elements: TextViews*/
        tvMainExpression = findViewById(R.id.tvMainExpression)
        tvMainCurrentResults = findViewById(R.id.tvMainCurrentResults)

        /*Binding visual elements: Operation buttons*/
        btMainClear = findViewById(R.id.btMainClear)
        btMainDivision = findViewById(R.id.btMainDivision)
        btMainMultiplication = findViewById(R.id.btMainMultiplication)
        btMainMinus = findViewById(R.id.btMainMinus)
        btMainPlus = findViewById(R.id.btMainPlus)
        btMainEqual = findViewById(R.id.btMainEqual)
        btMainRet = findViewById(R.id.btMainRet)

        /*Binding visual elements: Number buttons*/
        btMainDot = findViewById(R.id.btMainDot)
        btMainZero = findViewById(R.id.btMainZero)
        btMainOne = findViewById(R.id.btMainOne)
        btMainTwo = findViewById(R.id.btMainTwo)
        btMainThree = findViewById(R.id.btMainThree)
        btMainFour = findViewById(R.id.btMainFour)
        btMainFive = findViewById(R.id.btMainFive)
        btMainSix = findViewById(R.id.btMainSix)
        btMainSeven = findViewById(R.id.btMainSeven)
        btMainEight = findViewById(R.id.btMainEight)
        btMainNine = findViewById(R.id.btMainNine)

        /*==== Definition for each operation button ====*/
        btMainClear.setOnClickListener {
            operator = 0
            num1 = 0.0
            num2 = 0.0
            dotFlag = 0
            tvMainExpression.setText("")
            tvMainCurrentResults.setText("")
        }

        btMainDivision.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "$valueMainExpression/"
            tvMainExpression.text = operation
            operator = 4
        }

        btMainMultiplication.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "$valueMainExpression&#215;"
            tvMainExpression.text = operation
            operator = 3
        }

        btMainMinus.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "$valueMainExpression-"
            tvMainExpression.text = operation
            operator = 2
        }

        btMainPlus.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "$valueMainExpression+"
            tvMainExpression.text = operation
            operator = 1
        }

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

        btMainRet.setOnClickListener {
            //Toast.makeText(this, "Digits Qty: ${tvMainCurrentResults.length()}", Toast.LENGTH_LONG).show()
            val aux1: Int = tvMainCurrentResults.text.get(tvMainCurrentResults.length()-1).digitToInt()

            val aux2: String = (tvMainCurrentResults.text.toString().toDouble() - aux1.toDouble()).div(10).toInt().toString()
            //Toast.makeText(this, "Digit removed: $aux1", Toast.LENGTH_LONG).show()

            tvMainCurrentResults.text = aux2
        }

        /*==== Definition for each digit button ====*/
        btMainDot.setOnClickListener {
            val updatedDecimalValue: String
            if(tvMainCurrentResults.text.isEmpty()) {
                tvMainCurrentResults.text = "0."
                dotFlag = 1
            }
            else {
                if(tvMainCurrentResults.text.contains(".")) { dotFlag = 0 }
                else {
                    updatedDecimalValue = tvMainCurrentResults.text.toString() + "."
                    tvMainCurrentResults.text = updatedDecimalValue
                    dotFlag = 1
                }
            }
        }

        btMainZero.setOnClickListener {
            val zeroValue: String
            if(tvMainCurrentResults.text.isNotEmpty()) {
                zeroValue = tvMainCurrentResults.text.toString() + "0"
                tvMainCurrentResults.text = zeroValue
            }
            else { Toast.makeText(this, "No initial zeros allowed!", Toast.LENGTH_SHORT).show() }
        }

        btMainOne.setOnClickListener {
            val oneValue: String = tvMainCurrentResults.text.toString() + "1"
            tvMainCurrentResults.text = oneValue
        }

        btMainTwo.setOnClickListener {
            val twoValue: String = tvMainCurrentResults.text.toString() + "2"
            tvMainCurrentResults.text = twoValue
        }

        btMainThree.setOnClickListener {
            val threeValue: String = tvMainCurrentResults.text.toString() + "3"
            tvMainCurrentResults.text = threeValue
        }

        btMainFour.setOnClickListener {
            val fourValue: String = tvMainCurrentResults.text.toString() + "4"
            tvMainCurrentResults.text = fourValue
        }

        btMainFive.setOnClickListener {
            val fiveValue: String = tvMainCurrentResults.text.toString() + "5"
            tvMainCurrentResults.text = fiveValue
        }

        btMainSix.setOnClickListener {
            val sixValue: String = tvMainCurrentResults.text.toString() + "6"
            tvMainCurrentResults.text = sixValue
        }

        btMainSeven.setOnClickListener {
            val sevenValue: String = tvMainCurrentResults.text.toString() + "7"
            tvMainCurrentResults.text = sevenValue
        }

        btMainEight.setOnClickListener {
            val eightValue: String = tvMainCurrentResults.text.toString() + "8"
            tvMainCurrentResults.text = eightValue
        }

        btMainNine.setOnClickListener {
            val nineValue: String = tvMainCurrentResults.text.toString() + "9"
            tvMainCurrentResults.text = nineValue
        }
    }
    /*fun pressedKey(view: View){
        valueMainExpression = tvMainCurrentResults.text.toString()

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
    }*/
    /*fun selectOperator(view: View){
        valueMainExpression = tvMainCurrentResults.text.toString()
        num1 = valueMainExpression.toDouble()
        tvMainCurrentResults.text = ""


        when(view.id){
            *//*R.id.btMainClear -> tvMainCurrentResults.setText("0")*//*
            R.id.btMainPlus -> {
                tvMainExpression.text = valueMainExpression + "+"
                operator = 1
            }
            R.id.btMainMinus -> {
                tvMainExpression.text = valueMainExpression + "-"
                operator = 2
            }
            R.id.btMainMultiplication -> {
                tvMainExpression.text = valueMainExpression + "X"
                operator = 3
            }
            R.id.btMainDivision -> {
                tvMainExpression.text = valueMainExpression + "/"
                operator = 4
            }
        }
    }*/
}