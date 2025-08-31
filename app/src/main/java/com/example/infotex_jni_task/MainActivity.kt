package com.example.infotex_jni_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.infotex_jni_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSum.setOnClickListener{ sumBtn() }
        binding.btnMul.setOnClickListener { mulBtn() }
        binding.btnDiv.setOnClickListener { divBtn() }
        binding.btnSub.setOnClickListener { subBtn() }
    }

    fun sumBtn(){
        val a = binding.firstNum.text.toString().toDouble()
        val b = binding.secondNum.text.toString().toDouble()

        binding.result.text = Sum(a,b).toString()
    }

    fun mulBtn(){
        val a = binding.firstNum.text.toString().toDouble()
        val b = binding.secondNum.text.toString().toDouble()

        binding.result.text = Mult(a,b).toString()
    }

    fun divBtn(){
        val a = binding.firstNum.text.toString().toDouble()
        val b = binding.secondNum.text.toString().toDouble()

        try {
            binding.result.text = Div(a,b).toString()
        } catch (e: ArithmeticException){
            binding.result.text = e.message
        }
    }

    fun subBtn(){
        val a = binding.firstNum.text.toString().toDouble()
        val b = binding.secondNum.text.toString().toDouble()

        binding.result.text = Sub(a,b).toString()
    }

    external fun Sum(a: Double, b: Double): Double

    external fun Mult(a: Double, b: Double): Double

    external fun Div(a: Double, b: Double): Double

    external fun Sub(a: Double, b: Double): Double



    companion object {
        // Used to load the 'infotex_jni_task' library on application startup.
        init {
            System.loadLibrary("infotex_jni_task")
        }
    }
}

