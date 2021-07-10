package com.apolo.imc_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        Valor_Alt.doAfterTextChanged{ text ->
            //Toast.makeText(, this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        Valor_Peso.doOnTextChanged { text, _, _, _ ->
            //Calc_Title.text = text
        }
        Calcular.setOnClickListener {
            calcularIMC(Valor_Peso.text.toString(), Valor_Alt.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            Calc_Title.text = "Seu Imc é : %.2f".format(imc)
            if( imc < 18.5){
                inf.text =("Esta a baixo peso")
            }else if (imc >= 18.5 && imc <= 24.9){
                inf.text = ("Esta no Peso Ideal")
            }else if (imc >= 25 && imc <= 29.9){
                inf.text = ("Esta com Sobrepeso")
            }else if (imc >= 30 && imc <= 34.9){
                inf.text = ("Esta com obesidade classe I")
            }else if (imc >= 35 && imc <= 39.9){
                inf.text = ("Esta com obesidade classe II")
            }else if (imc >= 40){
                inf.text = ("Esta com obesidade classe III")
            }
        }
    }
}