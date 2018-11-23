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

var sunglasses = false
var hand = false
var cube = false
var shoe = false
var chair = false

class ImageLabelAdapter(private var firebaseVisionList: List<Any>) : RecyclerView.Adapter<ImageLabelAdapter.ItemHolder>() {

    lateinit var context: Context


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindCloud(currentItem: FirebaseVisionCloudLabel) {

            if (currentItem.confidence * 100 > 60) {
                itemView.itemName.text = currentItem.label
                itemView.itemAccuracy.text = "Probability : ${(currentItem.confidence * 100).toInt()}%"

                if (currentItem.label == "sunglasses" && (currentItem.confidence * 100).toInt() > 80) {
                    sunglasses = true
                }
                if (currentItem.label == "hand" && (currentItem.confidence * 100).toInt() > 80) {
                    hand = true
                }
                if (currentItem.label == "cube" && (currentItem.confidence * 100).toInt() > 80) {
                    cube = true
                }
                if (currentItem.label == "shoe" && (currentItem.confidence * 100).toInt() > 80) {
                    shoe = true
                }
                if (currentItem.label == "chair" && (currentItem.confidence * 100).toInt() > 80) {
                    chair = true
                }
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