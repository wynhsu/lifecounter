package edu.washington.wynhsu.lifecounter

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val p1array = arrayOf(btnP1p1, btnP1p5, btnP1n1, btnP1n5)
        val p2array = arrayOf(btnP2p1, btnP2p5, btnP2n1, btnP2n5)
        val p3array = arrayOf(btnP3p1, btnP3p5, btnP3n1, btnP3n5)
        val p4array = arrayOf(btnP4p1, btnP4p5, btnP4n1, btnP4n5)
        val map = hashMapOf(txtLP1 to p1array, txtLP2 to p2array, txtLP3 to p3array, txtLP4 to p4array)

        for (key in map.keys) {
            val array = map.get(key)
            btnClick(1, array!![0], key)
            btnClick(5, array!![1], key)
            btnClick(-1, array!![2], key)
            btnClick(-5, array!![3], key)
        }
    }

    fun btnClick(num: Int, btn: Button, txt: TextView) {
        btn.setOnClickListener{
            val numb = txt.text.toString().toInt()
            val incr = (numb + num).toString()
            txt.setText(incr)

            var player: Int
            if (incr.toInt() <= 0) {
                when(txt) {
                    txtLP1 -> player = 1
                    txtLP2 -> player = 2
                    txtLP3 -> player = 3
                    else -> player = 4
                }
                txt.setTextColor(Color.parseColor("#F44336"))
                Toast.makeText(applicationContext, "Player " + player + " Loses", Toast.LENGTH_SHORT).show()
            } else {
                txt.setTextColor(Color.parseColor("#000000"))
            }
        }
    }
}
