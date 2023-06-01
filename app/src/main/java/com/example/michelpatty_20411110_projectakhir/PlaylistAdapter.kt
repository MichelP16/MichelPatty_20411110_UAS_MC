package com.example.michelpatty_20411110_projectakhir

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaylistAdapter
    (
    private val context: Context,
    private val playlists: List<PlaylistData>,
    private val listener : (PlaylistData) -> Unit)
    :RecyclerView.Adapter<PlaylistAdapter.MyViewHolder>() {

    class MyViewHolder (PlaylistData: View) : RecyclerView.ViewHolder(PlaylistData) {
        private val imgPlaylist  = PlaylistData.findViewById<ImageView>(R.id.imgPlaylist)
        private val judulPlaylist  = PlaylistData.findViewById<TextView>(R.id.judulPlaylist)
        private  val artisPlaylist  = PlaylistData.findViewById<TextView>(R.id.artisPlaylist)

        fun bindView(lagu: PlaylistData, listener: (PlaylistData) -> Unit) {
            imgPlaylist.setImageResource(lagu.imgPlaylist)
            judulPlaylist.text = lagu.judulPlaylist
            artisPlaylist.text = lagu.artisPlaylist
            itemView.setOnClickListener{listener(lagu)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.playlist_data,parent,false))

    override fun getItemCount(): Int = playlists.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(playlists[position], listener)
    }
}