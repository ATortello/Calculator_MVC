package com.example.calculator_mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    private var valueMainExpression: String = ""
//    private var valueResult: String = ""
    private var value: String = ""
//    private var operation: String = ""
    private var operator: Int = 0
    private var dotFlag: Int = 0
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var countRet: Int = 0

    /*TextViews to show information*/
    private lateinit var tvMainExpression: TextView
    private lateinit var tvMainCurrentResults: TextView

    /*Operation Buttons*/
    private lateinit var btMainClear: Button
//    private lateinit var btMainParenthesis: Button
    private lateinit var btMainPercentage: Button
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
        btMainPercentage = findViewById(R.id.btMainPercentage)
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
        btMainClear.setOnClickListener { clearScreen() }
        btMainPercentage.setOnClickListener { typeOperator(5) }
        btMainDivision.setOnClickListener { typeOperator(4) }
        btMainMultiplication.setOnClickListener { typeOperator(3) }
        btMainMinus.setOnClickListener { typeOperator(2) }
        btMainPlus.setOnClickListener { typeOperator(1) }
        btMainEqual.setOnClickListener { calculate() }
        btMainRet.setOnClickListener { deleteCharacter() }

        /*==== Definition for each digit button ====*/
        btMainDot.setOnClickListener { handleDot() }
        btMainZero.setOnClickListener { zeroControl() }
        btMainOne.setOnClickListener { typeNumber("1") }
        btMainTwo.setOnClickListener { typeNumber("2") }
        btMainThree.setOnClickListener { typeNumber("3") }
        btMainFour.setOnClickListener { typeNumber("4") }
        btMainFive.setOnClickListener { typeNumber("5") }
        btMainSix.setOnClickListener { typeNumber("6") }
        btMainSeven.setOnClickListener { typeNumber("7") }
        btMainEight.setOnClickListener { typeNumber("8") }
        btMainNine.setOnClickListener { typeNumber("9") }
    }
    private fun typeNumber(number: String) {
        val value = StringBuilder(tvMainCurrentResults.text)
        value.append(number)
        tvMainCurrentResults.text = value.toString()
    }
    private fun handleDot(){
        val updatedDecimalValue: StringBuilder = StringBuilder()
        if(tvMainCurrentResults.text.isEmpty()) {
            tvMainCurrentResults.text = "0."
            dotFlag = 1
        }
        else {
            if(!tvMainCurrentResults.text.contains(".")) {
                updatedDecimalValue.append(tvMainCurrentResults.text).append(".")
                tvMainCurrentResults.text = updatedDecimalValue.toString()
                dotFlag = 1
            }
            else { dotFlag = 0 }
        }
    }
    private fun zeroControl(){
        val value: String
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
    private fun  typeOperator(number: Int) {
        var operation = ""
        val valueMainExpression: String = tvMainCurrentResults.text.toString()

        if (valueMainExpression.isNotEmpty()) {
            num1 = valueMainExpression.toDouble()
            tvMainCurrentResults.text = ""

            when(number) {
                1 -> operation = "${valueMainExpression}+"
                2 -> operation = "${valueMainExpression}-"
                3 -> operation = "${valueMainExpression}X"
                4 -> operation = "${valueMainExpression}/"
                5 -> operation = "${valueMainExpression}%"
            }
            tvMainExpression.text = operation
            operator = number
        }
        else {
            Toast
                .makeText(this, "Not a valid number!", Toast.LENGTH_SHORT)
                .show()
        }
    }
    private fun calculate() {
        var valueResult = ""

        if (tvMainCurrentResults.text.isNotEmpty()) {
            num2 = tvMainCurrentResults.text.toString().toDouble()

            when(operator) {
                1 -> valueResult = (num1 + num2).toString()
                2 -> valueResult = (num1 - num2).toString()
                3 -> valueResult = (num1 * num2).toString()
                4 -> valueResult = if (num2 == 0.0) "Can't divide by 0"
                else (num1 / num2).toString()
                5 -> valueResult = ((num1 * num2) / 100).toString()
            }

            tvMainCurrentResults.text = valueResult
            tvMainExpression.text = ""
        } else {
            if (operator == 5 && num1 > 0) { valueResult = (num1 / 100).toString() }

            tvMainCurrentResults.text = valueResult
            tvMainExpression.text = ""
        }
    }
    private fun clearScreen() {
        operator = 0
        num1 = 0.0
        num2 = 0.0
        dotFlag = 0
        countRet = 0
        tvMainExpression.text = ""
        tvMainCurrentResults.text = ""
    }
    private fun deleteCharacter(){
        val currentText = tvMainCurrentResults.text.toString()
        if (currentText.isNotEmpty())
            tvMainCurrentResults.text = currentText.substring(0, currentText.length - 1)
        else {
            countRet = 0
            Toast
                .makeText(this, "No more numbers to remove",Toast.LENGTH_SHORT)
                .show()
        }
    }
}