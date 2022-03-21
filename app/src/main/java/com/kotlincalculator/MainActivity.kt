package com.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.kotlincalculator.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var canAddDat = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun controlSpecialCharacters() : Boolean {
        return when {
            binding.process.text.last() == '.' -> false
            binding.process.text.last() == '%' -> false
            binding.process.text.last() == '+' -> false
            binding.process.text.last() == '-' -> false
            binding.process.text.last() == 'x' -> false
            binding.process.text.last() == '÷' -> false
            else -> true
        }
    }

    fun ClearAll(view: View) {
        binding.result.text = ""
        binding.process.text = ""
    }

    fun delete(view: View) {
        if(binding.process.text.isNotEmpty()) {
            binding.process.text = binding.process.text.subSequence(0, binding.process.text.length - 1)
        }
    }

    fun percent(view: View) {
        if(binding.process.text.isNotEmpty() && controlSpecialCharacters()) {
            binding.process.append("%")
            canAddDat = true
        }
    }

    fun divide(view: View) {
        if(binding.process.text.isNotEmpty() && controlSpecialCharacters()) {
            binding.process.append("÷")
            canAddDat = true
        }
    }

    fun multiplication(view: View) {
        if(binding.process.text.isNotEmpty() && controlSpecialCharacters()){
            binding.process.append("x")
            canAddDat = true
        }
    }

    fun minus(view: View) {
        if(binding.process.text.isNotEmpty() && controlSpecialCharacters()){
            binding.process.append("-")
            canAddDat = true
        }
    }
    fun plus(view: View) {
        if(binding.process.text.isNotEmpty() && controlSpecialCharacters()){
            binding.process.append("+")
            canAddDat = true
        }
    }

    fun equal(view: View) {}
    fun number(view: View) {
        if(view is Button) {
            when (view.text) {
                "9" -> binding.process.append("9")
                "8" -> binding.process.append("8")
                "7" -> binding.process.append("7")
                "6" -> binding.process.append("6")
                "5" -> binding.process.append("5")
                "4" -> binding.process.append("4")
                "3" -> binding.process.append("3")
                "2" -> binding.process.append("2")
                "1" -> binding.process.append("1")
                "0" -> binding.process.append("0")
                "." -> {
                    if(binding.process.text.isNotEmpty() && canAddDat && controlSpecialCharacters()) {
                        if(binding.process.text.last() != '.') {
                            binding.process.append(".")
                            canAddDat = false
                        }
                    }
                }
            }
        }
    }
}