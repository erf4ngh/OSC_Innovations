package com.google.firebase.codelab.image_labeling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_itemlist.*
import android.view.View
import java.util.*

class itemlist : AppCompatActivity() {

    var random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemlist)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Scavenger Hunt List"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        if (itemName == "yellow" || itemName == "red"){
            txtItem.setText("something that is the colour " + itemName)
        }
        else{
            txtItem.setText(itemName)
        }

        if (itemFound == true){
            txtPrompt.setText("Well done, you found it! Use the button below to find your next item!")
        }

        if (difficulty == false){
            radEasy.isChecked = true
        }
        if (difficulty == true){
            radHard.isChecked = true
        }

        val radEasyCheck = View.OnClickListener {
            radHard.isChecked = false
            difficulty = false
        }
        val radHardCheck = View.OnClickListener {
            radEasy.isChecked = false
            difficulty = true
        }

        val newItemGen = View.OnClickListener {
            if (radEasy.isChecked == true || radHard.isChecked == true){

                while (itemNum == tempNum){
                    itemNum = random.nextInt(5 + 0) + 0
                }

                tempNum = itemNum

                if (radEasy.isChecked == true){
                    itemName =  easyList[itemNum]
                }
                if (radHard.isChecked == true){
                    itemName = hardList[itemNum]
                }

                if (itemName == "yellow" || itemName == "red"){
                    txtItem.setText("something that is the colour " + itemName)
                }
                else{
                    txtItem.setText(itemName)
                }

                txtPrompt.setText("")
            }
        }

        btnNew.setOnClickListener(newItemGen)
        radEasy.setOnClickListener(radEasyCheck)
        radHard.setOnClickListener(radHardCheck)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
