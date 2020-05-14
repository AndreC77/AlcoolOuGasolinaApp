package br.com.andrecoelho.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var valorGasolina = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //carregar os componetes
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btn = findViewById<Button>(R.id.btnCalcular)

        //Tamanho da SeekBar
        seekBar.max = 1000

        //Definir um Listener para SeekBar
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGasolina = progress
                var texto = "R$ "
                texto += formataValor(valorGasolina/100.0)
                txtGasolina.text = texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                txtResultado.text = "Selecione o valor da Gasolina"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
               txtResultado.text = "Clique em Calcular para saber o resultado"
            }

        })

        //listenr do botão
        btn.setOnClickListener {
            var valorResultado = (valorGasolina * 0.7)/100.0
            var texto = "Abasteça com Alcool se ele custar até: R$ "
            texto += formataValor(valorResultado)
            txtResultado.text = texto
        }

    }

    private fun formataValor(valor: Double): Any? {
        return String.format(Locale.FRANCE, "%.2f", valor)
    }
}
