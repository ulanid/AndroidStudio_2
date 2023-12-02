package com.example.musicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SongAdapter : RecyclerView.Adapter<SongAdapter.MusicViewHolder>() {

    private val list = ArrayList<Song>()
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(music: Song)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setList(newList: List<Song>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(element)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val songIcon: ImageView = itemView.findViewById(R.id.songIcon)
        private val songName: TextView = itemView.findViewById(R.id.songName)
        private val songAuthor: TextView = itemView.findViewById(R.id.songAuthor)

        fun bind(item: Song) {
            songName.text = item.name
            songAuthor.text = item.author

            Glide.with(itemView.context)
                .load(item.icon)
                .into(songIcon)
        }
    }
}

