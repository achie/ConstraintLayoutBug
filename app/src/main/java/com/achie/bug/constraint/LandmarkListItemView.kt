package com.achie.bug.constraint

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_landmark_list_item.view.*

class LandmarkListItemView : ConstraintLayout {

    constructor(context: Context) : super(context) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context)
    }

    private fun initialize(context: Context) {
        inflate(context, R.layout.view_landmark_list_item, this)
    }

    fun setLandmark(landmark: Landmark) {
        Glide.with(context)
            .load(landmark.imageResId)
            .centerCrop()
            .into(landmarkIv)
        titleTv.text = landmark.title
        subtitleTv.text = landmark.subtitle
        descriptionTv.text = landmark.description
    }

}