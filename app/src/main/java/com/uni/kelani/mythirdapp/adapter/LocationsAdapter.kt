package com.uni.kelani.mythirdapp.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uni.kelani.mythirdapp.R
import com.uni.kelani.mythirdapp.model.Locations
import com.uni.kelani.mythirdapp.model.Photos
import java.net.URL

class LocationsAdapter(private val mList: List<Locations>) : RecyclerView.Adapter<LocationsAdapter.ViewHolder>(){


// create new views
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    // inflates the card_view_design view
    // that is used to hold list item
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.card_view_design, parent, false)

    return ViewHolder(view)
}

// binds the list items to a view
override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    val ItemsViewModel = mList[position]

    // sets the image to the imageview from our itemHolder class
    //val newURL= URL(ItemsViewModel.url)
    //val mIcon_val= BitmapFactory.decodeStream(newURL.openConnection().getInputStream())
   // holder.imageView.setImageBitmap(mIcon_val)

    // sets the text to the textview from our itemHolder class
    holder.textView.text = ItemsViewModel.location_name

}

// Holds the views for adding it to image and text
class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
   // val imageView: ImageView = itemView.findViewById(R.id.imageview)
    val textView: TextView = itemView.findViewById(R.id.textView)
}

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}