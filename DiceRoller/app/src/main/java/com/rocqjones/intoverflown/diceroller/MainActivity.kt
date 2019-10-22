 package com.rocqjones.intoverflown.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

 class MainActivity : AppCompatActivity() {

     lateinit var diceImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //let's reference btn
        val rollBtn: Button = findViewById(R.id.roll_button);
        //then onClickListener
        rollBtn.setOnClickListener {
            //Toast.makeText(this, "Let's roll", Toast.LENGTH_SHORT);
            //calls method
            rollDice()
        }
        diceImg = findViewById(R.id.dice_img)

    }

     private fun rollDice() {
//         val resultTxt: TextView = findViewById(R.id.results_text);
//         //generates rand nums btwn 1 to 6. Note + 1 tells Kt to start at 1
//         val randomInt =  Random().nextInt(6) + 1
//         resultTxt.text = randomInt.toString()

         //Now lets use Images instead of nums we use real dices
         val randomInt =  Random().nextInt(6) + 1

         // getting all random imgs for the dices
         val drawableResourse = when (randomInt) {
             1 -> R.drawable.dice_1
             2 -> R.drawable.dice_2
             3 -> R.drawable.dice_3
             4 -> R.drawable.dice_4
             5 -> R.drawable.dice_5
             else -> R.drawable.dice_6
         }
         diceImg.setImageResource(drawableResourse)
     }
 }
