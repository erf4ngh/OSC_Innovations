package com.google.firebase.codelab.image_labeling

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_itemlist.*
import android.view.View

class itemlist : AppCompatActivity() {

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

        if (sunglasses == true) {
            txtItem1.setText("     sunglasses found!")
        }
        if (hand == true){
            txtItem2.setText("     hand found!")
        }
        if (cube == true){
            txtItem3.setText("     cube found!")
        }
        if (shoe == true){
            txtItem4.setText("     shoe found!")
        }
        if (chair == true){
            txtItem5.setText("     chair found!")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
