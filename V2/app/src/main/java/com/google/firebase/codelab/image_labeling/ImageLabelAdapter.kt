package com.google.firebase.codelab.image_labeling

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel
import com.google.firebase.ml.vision.label.FirebaseVisionLabel
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.activity_main.*

var itemFound = false
val list = arrayOf("yellow", "red", "flower", "sunglasses", "hand", "butterfly", "jewelry", "blue", "green", "apple", "orange", "banana", "balloon", "dog-like mammal", "darts")
var itemNum = 0
var tempNum = 0
var itemName = ""
var difficulty = false

class ImageLabelAdapter(private var firebaseVisionList: List<Any>) : RecyclerView.Adapter<ImageLabelAdapter.ItemHolder>() {

    lateinit var context: Context


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindCloud(currentItem: FirebaseVisionCloudLabel) {


            itemView.itemName.text = currentItem.label
            itemView.itemAccuracy.text = "Probability : ${(currentItem.confidence * 100).toInt()}%"

            if (currentItem.label == itemName){
                itemFound = true
            }

        }

        fun bindDevice(currentItem: FirebaseVisionLabel) {
            itemView.itemName.text = currentItem.label
            itemView.itemAccuracy.text = "Probability : ${(currentItem.confidence * 100).toInt()}%"
        }
    }

    fun setList(visionList: List<Any>) {
        firebaseVisionList = visionList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currentItem = firebaseVisionList[position]
        if (currentItem is FirebaseVisionCloudLabel)
            holder.bindCloud(currentItem)
        else
            holder.bindDevice(currentItem as FirebaseVisionLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        context = parent.context
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount() = firebaseVisionList.size

}