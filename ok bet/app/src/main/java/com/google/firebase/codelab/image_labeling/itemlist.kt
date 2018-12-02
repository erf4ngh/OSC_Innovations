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

        //first text generation
        if (itemName == "yellow" || itemName == "red" || itemName == "blue" || itemName == "green"){
            txtItem.setText("something that is the colour " + itemName)
        }
        else{
            txtItem.setText(itemName)
        }

        //check item
        if (itemFound == true){
            txtPrompt.setText("OK bet")
        }

        // next item generation
        val newItemGen = View.OnClickListener {
            while (itemNum == tempNum){
                    itemNum = random.nextInt(listO.size + 0) + 0
                }

                tempNum = itemNum

               itemName =  listO[itemNum]

                if (itemName == "yellow" || itemName == "red" || itemName == "blue" || itemName == "green"){
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
