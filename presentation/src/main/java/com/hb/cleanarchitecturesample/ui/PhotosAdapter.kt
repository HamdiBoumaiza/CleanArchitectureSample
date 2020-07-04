package com.hb.cleanarchitecturesample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hb.cleanarchitecturesample.R
import com.hb.domain.models.PhotoModel
import kotlinx.android.synthetic.main.item_photo.view.*


class PhotosAdapter(
    private var itemClickListener: PhotosClickListener,
    private var listPhotos: List<PhotoModel>
) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return listPhotos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(listPhotos[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage: ImageView = view.img_photo

        init {
            itemView.setOnClickListener {
                itemClickListener.onPhotoItemClicked(listPhotos[adapterPosition])
            }
        }

        fun bindViewHolder(photoModel: PhotoModel) {
            itemImage.load(photoModel.urls.regular)
        }
    }
}