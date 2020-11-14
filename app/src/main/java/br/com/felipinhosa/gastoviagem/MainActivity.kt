package br.com.felipinhosa.gastoviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener {

            it.setBackgroundResource(R.drawable.bg_button_rounded_black)

            calculate()

        }

    }


    private fun calculate() {
        if (validationOK()) {

            try {

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
                    .show()
            }


            val distance = editDistance.text.toString().toFloat()

            val autonomy = editAutonomy.text.toString().toFloat()

            val price = editPrice.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

            textViewTotalValue.text = ("R$ ${"%.2f".format(totalValue)}")
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }

    }

    private fun validationOK(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0")
    }

}