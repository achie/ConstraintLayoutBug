package com.achie.bug.constraint

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_landmark_list_item.view.*

class LandmarksAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private val landmarks: MutableList<Landmark> = mutableListOf()

    override fun getItemCount() = landmarks.size

    override fun getItemViewType(position: Int) = position % 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> NonCustomViewLayoutViewHolder(
                inflater.inflate(R.layout.view_landmark_list_item, parent, false)
            )

            else -> CustomViewLayoutViewHolder(
                inflater.inflate(R.layout.list_item_landmark, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 ->
                (holder as NonCustomViewLayoutViewHolder).bind(landmarks[position])

            else ->
                (holder as CustomViewLayoutViewHolder).bind(landmarks[position])
        }
    }

    fun setLandmarks(landmarks: List<Landmark>) {
        this.landmarks.clear()
        this.landmarks.addAll(landmarks)
        notifyDataSetChanged()
    }

    inner class CustomViewLayoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var landmarkView: LandmarkListItemView = view as LandmarkListItemView

        fun bind(landmark: Landmark) {
            landmarkView.setLandmark(landmark)
        }
    }

    inner class NonCustomViewLayoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(landmark: Landmark) {
            Glide.with(itemView.context)
                .load(landmark.imageResId)
                .centerCrop()
                .into(itemView.landmarkIv)
            itemView.titleTv.text = landmark.title
            itemView.subtitleTv.text = landmark.subtitle
            itemView.descriptionTv.text = landmark.description

            itemView.statusTv.text = "Good Margins"
            itemView.statusTv.setTextColor(
                ContextCompat.getColor(itemView.context, R.color.text_non_buggy))
        }
    }

}