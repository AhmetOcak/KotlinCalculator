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
    var canAddOperationKey = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun controlDat() : Boolean {
        if(binding.process.text.contains(".")) return false
        return true
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

    }
    fun divide(view: View) {}
    fun multiplication(view: View) {}
    fun minus(view: View) {}
    fun plus(view: View) {}
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
                    if(binding.process.text.isNotEmpty() && controlDat()) {
                        if(binding.process.text.last() != '.') {
                            binding.process.append(".")
                        }
                    }
                }
            }
        }
    }
}