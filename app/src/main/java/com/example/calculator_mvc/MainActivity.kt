package com.example.calculator_mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var valueMainExpression: String = ""
    private var valueResult: String = ""
    private var value: String = ""
    private var operation: String = ""
    private var operator: Int = 0
    private var dotFlag: Int = 0
    private var num1: Double = 0.0
    private var num2: Double = 0.0

    /*TextViews to show information*/
    private lateinit var tvMainExpression: TextView
    private lateinit var tvMainCurrentResults: TextView

    /*Operation Buttons*/
    private lateinit var btMainClear: Button
    /*private lateinit var btMainParenthesis: Button
    private lateinit var btMainPercentage: Button*/
    private lateinit var btMainDivision: Button
    private lateinit var btMainMultiplication: Button
    private lateinit var btMainMinus: Button
    private lateinit var btMainPlus: Button
    private lateinit var btMainEqual: Button
    private lateinit var btMainRet: Button

    /*All Number Buttons*/
    private lateinit var btMainDot: Button
    private lateinit var btMainZero: Button
    private lateinit var btMainOne: Button
    private lateinit var btMainTwo: Button
    private lateinit var btMainThree: Button
    private lateinit var btMainFour: Button
    private lateinit var btMainFive: Button
    private lateinit var btMainSix: Button
    private lateinit var btMainSeven: Button
    private lateinit var btMainEight: Button
    private lateinit var btMainNine: Button
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
            tvMainExpression.text = ""
            tvMainCurrentResults.text = ""
        }

        btMainDivision.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "${valueMainExpression}/"
            tvMainExpression.text = operation
            operator = 4
        }

        btMainMultiplication.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "${valueMainExpression}X"
            tvMainExpression.text = operation
            operator = 3
        }

        btMainMinus.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "${valueMainExpression}-"
            tvMainExpression.text = operation
            operator = 2
        }

        btMainPlus.setOnClickListener{
            valueMainExpression = tvMainCurrentResults.text.toString()
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            operation = "${valueMainExpression}+"
            tvMainExpression.text = operation
            operator = 1
        }

        btMainEqual.setOnClickListener {
            num2 = tvMainCurrentResults.text.toString().toDouble()

            when(operator){
                1 -> valueResult = (num1 + num2).toString()
                2 -> valueResult = (num1 - num2).toString()
                3 -> valueResult = (num1 * num2).toString()
                4 -> valueResult = if (num2 == 0.0) "Can't divide by 0"
                else (num1 / num2).toString()
            }

            tvMainCurrentResults.text = valueResult
            tvMainExpression.text = ""
        }

        btMainRet.setOnClickListener {
//            Toast.makeText(this, "Digits Qty: ${tvMainCurrentResults.length()}", Toast.LENGTH_LONG).show()
//            val aux1: Int = tvMainCurrentResults.text
//                .get(tvMainCurrentResults.length()-1)
//                .digitToInt()
//
//            val aux2: String = (tvMainCurrentResults.text.toString().toDouble() - aux1.toDouble())
//                .div(10).toInt().toString()
//            Toast.makeText(this, "Digit removed: $aux1", Toast.LENGTH_LONG).show()
//
//            tvMainCurrentResults.text = aux2
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
            if(tvMainCurrentResults.text.isNotEmpty()) {
                value = tvMainCurrentResults.text.toString() + "0"
                tvMainCurrentResults.text = value
            }
            else {
                if (operator == 4) tvMainCurrentResults.text = "0"
                else Toast
                    .makeText(this, "No initial zeros allowed!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        btMainOne.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "1"
            tvMainCurrentResults.text = value
        }

        btMainTwo.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "2"
            tvMainCurrentResults.text = value
        }

        btMainThree.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "3"
            tvMainCurrentResults.text = value
        }

        btMainFour.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "4"
            tvMainCurrentResults.text = value
        }

        btMainFive.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "5"
            tvMainCurrentResults.text = value
        }

        btMainSix.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "6"
            tvMainCurrentResults.text = value
        }

        btMainSeven.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "7"
            tvMainCurrentResults.text = value
        }

        btMainEight.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "8"
            tvMainCurrentResults.text = value
        }

        btMainNine.setOnClickListener {
            value = tvMainCurrentResults.text.toString() + "9"
            tvMainCurrentResults.text = value
        }
    }
}