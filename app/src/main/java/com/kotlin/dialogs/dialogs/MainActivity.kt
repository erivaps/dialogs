package com.kotlin.dialogs.dialogs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var estado = 0
    var incremento = 0

    lateinit var slider: SeekBar //lateinit para q acepte nulos como el ?=null
    lateinit var valor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDescarga.setOnClickListener { view ->
            //hilo cada 10 espera medio seg
            Thread(Runnable {
                while (estado < 100) {
                    try {
                        incremento += 10
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    estado = incremento
                    pbProgreso.progress = incremento
                }

                //if (incremento == 100)
               // pbProgreso.visibility = View.INVISIBLE
            }).start() // para que inicie


        }


        slider = seekBar
        valor = txtResultado
        slider.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })


    }
}
