package com.example.michelpatty_20411110_projectakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter
    (
    private val context: Context,
    private val lagus: List<itemData>,
    private val listener : (itemData) -> Unit)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder (itemData: View) : RecyclerView.ViewHolder(itemData) {
        private val img  = itemData.findViewById<ImageView>(R.id.img)
        private val album  = itemData.findViewById<TextView>(R.id.album)
        private  val artis  = itemData.findViewById<TextView>(R.id.artis)

//        private val  img2 = itemData.findViewById<ImageView>(R.id.img2)
//        private val judul2  = itemData.findViewById<TextView>(R.id.judul2)
//        private  val artis2  = itemData.findViewById<TextView>(R.id.artis2)

        fun bindView(lagu: itemData, listener: (itemData) -> Unit) {
            img.setImageResource(lagu.img)
            album.text = lagu.album
            artis.text = lagu.artis
//            img2.setImageResource(lagu.img2)
//            judul2.text = lagu.judul2
//            artis2.text = lagu.artis2
            itemView.setOnClickListener{listener(lagu)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false))

    override fun getItemCount(): Int = lagus.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(lagus[position], listener)
    }
}