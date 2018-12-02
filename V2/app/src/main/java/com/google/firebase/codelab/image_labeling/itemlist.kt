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

        if (itemName == "yellow" || itemName == "red" || itemName == "green" || itemName == "blue"){
            txtItem.setText("something that is the colour " + itemName)
        }
        else{
            txtItem.setText(itemName)
        }

        if (itemFound == true){
            txtPrompt.setText("Well done, you found it! Use the button below to find your next item!")
        }

        val newItemGen = View.OnClickListener {
            while (itemNum == tempNum){
                    itemNum = random.nextInt(5 + 0) + 0
                }

                tempNum = itemNum

                if (itemName == "yellow" || itemName == "red"){
                    txtItem.setText("something that is the colour " + itemName)
                }
                else{
                    txtItem.setText(itemName)
                }

                txtPrompt.setText("")
            }

        btnNew.setOnClickListener(newItemGen)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
