package com.google.firebase.codelab.image_labeling

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_itemlist.*
import android.content.Intent


abstract class BaseCameraActivity : AppCompatActivity(), View.OnClickListener {

    val sheetBehavior by lazy {
        BottomSheetBehavior.from(layout_bottom_sheet)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraView.start()
        btnRetry.setOnClickListener {
            if (cameraView.visibility == View.VISIBLE) showPreview() else hidePreview()
        }
        fab_take_photo.setOnClickListener(this)
        sheetBehavior.peekHeight = 224
        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

        fab_itemlist.setOnClickListener{
            val intent = Intent(this, itemlist::class.java)
            startActivity(intent)
        }

        var itemList = arrayOf("shoe", "sunglasses")



    }


    //override fun onResume() {
    //    super.onResume()
    //    cameraView.start()
    //}

    //override fun onPause() {
    //    cameraView.stop()
    //    super.onPause()
    //}

    protected fun showPreview() {
        framePreview.visibility = View.VISIBLE
        cameraView.visibility = View.GONE
    }

    protected fun hidePreview() {
        framePreview.visibility = View.GONE
        cameraView.visibility = View.VISIBLE
    }

}

