package com.harchet.recyclingviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val insectList :ArrayList<insects>): RecyclerView.Adapter<Adapter.InsectViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsectViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,false)

        return InsectViewHolder(viewLayout)
    }

    override fun getItemCount(): Int {
      return insectList.size
    }

    override fun onBindViewHolder(holder: InsectViewHolder, position: Int) {
        val current= insectList[position]
        holder.img.setImageResource(current.img)

//        setting up holder with the image from insectList[position]
        // the holder is the exact view that created for list items
        holder.title.text= current.title
        val str= current.title.substring(10)
        holder.contentDescription= str

        // after this we have set our holder which is holding a view at this moment
    }

    class InsectViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        var contentDescription= itemview.findViewById<View>(R.id.view).contentDescription
        val img=  itemview.findViewById<ImageView>(R.id.titleimage)
        val title= itemview.findViewById<TextView>(R.id.title)
    }
}