package com.mutia.latihan13sep


import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.mutia.latihan13sep.Adapter.PhotoGridAdapter

class GalleryPhotoActivity : AppCompatActivity() {

    // Sample image resource array
    private val imageList = arrayOf(
        R.drawable.mi,
        R.drawable.rpl,
        R.drawable.ti,
        R.drawable.tk

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_photo)

        // Set up the GridView for photos
        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = PhotoGridAdapter(this, imageList)
        gridView.adapter = adapter

        // Set up onClickListener for grid items
        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, PhotoDetailActivity::class.java)
            intent.putExtra("imageResId", imageList[position]) // Pass the selected image ID to detail activity
            startActivity(intent)
        }
    }
}