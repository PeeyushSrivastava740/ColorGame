package com.indraprastha.mytask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

import android.graphics.drawable.ColorDrawable

class MainActivity : AppCompatActivity() {
    private lateinit var v1:View
    private lateinit var v2:View
    private lateinit var v3:View
    private lateinit var v4:View
    private lateinit var score:TextView
    var count=0
    lateinit var   changingButtons: Array<ColorDrawable?>

    val INTERVAL = 1000 // 1000=1sec

    var whichColor = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        Thread {
            while (true) {
                try {
                    Thread.sleep(INTERVAL.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                updateColor()
                whichColor = !whichColor
            }
        }.start()

    }

    private fun updateColor() {
        runOnUiThread {
                if (whichColor ) {
                    v1.setBackgroundColor(Color.GRAY)
                    v2.setBackgroundColor(Color.GRAY)
                    v3.setBackgroundColor(Color.GRAY)
                    v4.setBackgroundColor(Color.GRAY)

                    changingButtons = arrayOfNulls<ColorDrawable>(4)

                    changingButtons[0] = v1.background as ColorDrawable
                    changingButtons[1] = v2.background as ColorDrawable
                    changingButtons[2] = v3.background as ColorDrawable
                    changingButtons[3] = v4.background as ColorDrawable

                    v1.setOnClickListener {
                      //  val buttonColor = v1.background as ColorDrawable
                        val color = changingButtons[0]!!.color
                        if (color == Color.RED) {
                            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                            count=0
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }

                    v2.setOnClickListener {
                      //  val buttonColor = v2.background as ColorDrawable
                        val color =  changingButtons[1]!!.color
                        if (color == Color.GREEN) {
                            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                            count=0
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }

                    v3.setOnClickListener {
                      //  val buttonColor = v3.background as ColorDrawable
                        val color =  changingButtons[2]!!.color
                        if (color == Color.BLUE) {
                            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                            count=0
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }
                    v4.setOnClickListener {
                       // val buttonColor = v4.background as ColorDrawable
                        val color =  changingButtons[3]!!.color
                        if (color == Color.YELLOW) {
                            Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                            count=0
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }

                } else{
                    v1.setBackgroundColor(Color.RED)
                    v2.setBackgroundColor(Color.GREEN)
                    v3.setBackgroundColor(Color.BLUE)
                    v4.setBackgroundColor(Color.YELLOW)

                    changingButtons = arrayOfNulls<ColorDrawable>(4)

                    changingButtons[0] = v1.background as ColorDrawable
                    changingButtons[1] = v2.background as ColorDrawable
                    changingButtons[2] = v3.background as ColorDrawable
                    changingButtons[3] = v4.background as ColorDrawable

                    val color =  changingButtons[0]!!.color
                    if (color == Color.GRAY) {
                        v1.setBackgroundColor(Color.RED)
                    }else{
                        v1.setBackgroundColor(Color.GRAY)
                    }

                    v1.setOnClickListener {

//                        val buttonColor = v1.background as ColorDrawable
                        val color =  changingButtons[0]!!.color
                        if (color == Color.GRAY) {
                            count++
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }else{
                            v1.setBackgroundColor(Color.RED)
                        }
                    }

                    v2.setOnClickListener {
                        val color =  changingButtons[1]!!.color
                        if (color == Color.GRAY) {
                            count++
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }

                    v3.setOnClickListener {
                        val color =  changingButtons[2]!!.color
                        if (color == Color.GRAY) {
                            count++
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }
                    v4.setOnClickListener {
                        val color =  changingButtons[3]!!.color
                        if (color == Color.GRAY) {
                            count++
                            score.text = "Your Score".plus(":").plus("").plus(count.toString())
                        }
                    }

                }

        }
    }

    private fun initView() {
        v1 = findViewById(R.id.v1)
        v2 = findViewById(R.id.v2)
        v3 = findViewById(R.id.v3)
        v4 = findViewById(R.id.v4)

        score = findViewById(R.id.textView)
//        changingButtons = arrayOfNulls<View>(4)
//        changingButtons[0] = findViewById(R.id.v1) as View
//        changingButtons[1] = findViewById(R.id.v2) as View
//        changingButtons[2] = findViewById(R.id.v3) as View
//        changingButtons[3] = findViewById(R.id.v4) as View
        v1.setBackgroundColor(Color.GRAY)
        v2.setBackgroundColor(Color.GRAY)
        v3.setBackgroundColor(Color.GRAY)
        v4.setBackgroundColor(Color.GRAY)

    }


}







