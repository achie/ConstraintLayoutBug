package com.achie.bug.constraint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLandmarks()
    }

    private fun showLandmarks() {
        recyclerView.addItemDecoration(
            DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.list_divider_landmarks)!!)
            }
        )

        recyclerView.adapter = LandmarksAdapter(applicationContext).apply {
            setLandmarks(getDoubledLandmarks())
        }
    }

    private fun getDoubledLandmarks() =
        mutableListOf<Landmark>().apply {
            ListContents.LANDMARKS.forEach {
                add(it)
                add(it)
            }
        }

}
