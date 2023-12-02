package com.example.musicplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SongInfoFragment : Fragment() {
    var icon: Int? = null
    var name: String? = null
    var author: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        icon = arguments?.getInt("icon")
        name = arguments?.getString("name")
        author = arguments?.getString("author")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_info, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameView: TextView = view.findViewById(R.id.NameInfo)
        val authorView: TextView = view.findViewById(R.id.AuthorInfo)
        val iconView: ImageView = view.findViewById(R.id.IconInfo)

        nameView.text = name
        authorView.text = author
        Glide.with(view.context)
            .load(icon)
            .into(iconView)
    }


}